package com.ozeratar.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ozeratar.rentACar.business.abstracts.ModelService;
import com.ozeratar.rentACar.business.requests.create.CreateModelRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateModelRequest;
import com.ozeratar.rentACar.business.responses.create.CreateModelResponse;
import com.ozeratar.rentACar.business.responses.get.GetModelResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllModelsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateModelResponse;
import com.ozeratar.rentACar.dataAccess.ModelRepository;
import com.ozeratar.rentACar.entities.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	private ModelRepository modelRepository;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<GetAllModelsResponse> modelsResponse = new ArrayList<GetAllModelsResponse>();
		List<Model> models = modelRepository.findAll();

		for (Model model : models) {
			GetAllModelsResponse response = new GetAllModelsResponse();
			response.setId(model.getId());
			response.setName(model.getName());

			modelsResponse.add(response);

		}
		return modelsResponse;
	}

	@Override
	public GetModelResponse getById(int id) {
		GetModelResponse response = new GetModelResponse();
		Model model = modelRepository.findById(id).orElse(null);
		response.setId(model.getId());
		response.setName(model.getName());
		return response;
	}

	@Override
	public CreateModelResponse add(CreateModelRequest createModelRequest) {
		CreateModelResponse response = new CreateModelResponse();
		Model model = new Model();
		 model.setName(createModelRequest.getName());
		 
		 modelRepository.save(model);
		 response.setId(model.getId());
		 response.setName(model.getName());
		 
		return response;
	}

	@Override
	public UpdateModelResponse update(UpdateModelRequest updateModelRequest) {
		UpdateModelResponse response = new UpdateModelResponse();
		Model model = modelRepository.findById(updateModelRequest.getId()).orElse(null);
		
		model.setName(updateModelRequest.getName());
		modelRepository.save(model);
		response.setId(model.getId());
		response.setName(model.getName());
		return response;
	}

	@Override
	public void delete(int id) {
		modelRepository.deleteById(id);
	}

}
