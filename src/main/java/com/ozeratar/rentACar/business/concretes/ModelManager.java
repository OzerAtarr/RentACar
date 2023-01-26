package com.ozeratar.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozeratar.rentACar.business.abstracts.ModelService;
import com.ozeratar.rentACar.business.constants.BusinessMessages;
import com.ozeratar.rentACar.business.requests.create.CreateModelRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateModelRequest;
import com.ozeratar.rentACar.business.responses.create.CreateModelResponse;
import com.ozeratar.rentACar.business.responses.get.GetModelResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllModelsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateModelResponse;
import com.ozeratar.rentACar.core.utilities.exceptions.BusinessException;
import com.ozeratar.rentACar.core.utilities.mapping.ModelMapperService;
import com.ozeratar.rentACar.dataAccess.ModelRepository;
import com.ozeratar.rentACar.entities.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		List<GetAllModelsResponse> modelsResponse = models.stream().map(model -> this.modelMapperService.forResponse()
				.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		return modelsResponse;
	}

	@Override
	public GetModelResponse getById(int id) {
		checkIfModelExists(id);
		Model model = modelRepository.findById(id).orElse(null);
		GetModelResponse response = modelMapperService.forResponse().map(model, GetModelResponse.class);
		return response;
	}

	@Override
	public CreateModelResponse add(CreateModelRequest createModelRequest) {
		checkIfModelExistsByName(createModelRequest.getName());
		Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
		Model addedModel= modelRepository.save(model);
		CreateModelResponse response = modelMapperService.forResponse().map(addedModel, CreateModelResponse.class);
		return response;
	}

	@Override
	public UpdateModelResponse update(UpdateModelRequest updateModelRequest) {
		checkIfModelExists(updateModelRequest.getId());
		checkIfModelExistsByName(updateModelRequest.getName());
		Model model = new Model();
		Model addedModel = modelRepository.save(model);
		UpdateModelResponse response = modelMapperService.forResponse().map(addedModel,UpdateModelResponse.class);
		return response;
	}

	@Override
	public void delete(int id) {
		checkIfModelExists(id);
		modelRepository.deleteById(id);
	}
	
	private void checkIfModelExists(int id) {
		Model model = modelRepository.findById(id).orElse(null);
		if(model== null) {
			throw new BusinessException(BusinessMessages.ModelNoExists);
		}
	}
	
	private void checkIfModelExistsByName(String name) {
		Model model = modelRepository.findByName(name);
		if(model!= null) {
			throw new BusinessException(BusinessMessages.ModelExists);
		}
	}
}
