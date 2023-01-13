package com.ozeratar.rentACar.business.abstracts;

import java.util.List;

import com.ozeratar.rentACar.business.requests.create.CreateModelRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateModelRequest;
import com.ozeratar.rentACar.business.responses.create.CreateModelResponse;
import com.ozeratar.rentACar.business.responses.get.GetModelResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllModelsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateModelResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	GetModelResponse getById(int id);
	CreateModelResponse add(CreateModelRequest createModelRequest);
	UpdateModelResponse update(UpdateModelRequest updateModelRequest);
	void delete(int id);

}
