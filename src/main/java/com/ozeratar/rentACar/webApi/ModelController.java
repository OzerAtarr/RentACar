package com.ozeratar.rentACar.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozeratar.rentACar.business.abstracts.ModelService;
import com.ozeratar.rentACar.business.requests.create.CreateModelRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateModelRequest;
import com.ozeratar.rentACar.business.responses.create.CreateModelResponse;
import com.ozeratar.rentACar.business.responses.get.GetModelResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllModelsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateModelResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {
	private ModelService modelService;
	
	@GetMapping
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetModelResponse getById(@PathVariable int id) {
		return modelService.getById(id);
	}
	
	@PostMapping
	public CreateModelResponse add(@RequestBody CreateModelRequest createModelRequest) {
		return modelService.add(createModelRequest);
	}
	
	@PutMapping
	public 	UpdateModelResponse update(@RequestBody UpdateModelRequest updateModelRequest) {
		return modelService.update(updateModelRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		modelService.delete(id);
	}


}
