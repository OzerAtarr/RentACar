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

import com.ozeratar.rentACar.business.abstracts.CarService;
import com.ozeratar.rentACar.business.requests.create.CreateCarRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateCarRequest;
import com.ozeratar.rentACar.business.responses.create.CreateCarResponse;
import com.ozeratar.rentACar.business.responses.get.GetCarResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllCarsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateCarResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {
	private CarService carService;
	
	@GetMapping
	public List<GetAllCarsResponse> getAll(){
		return carService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetCarResponse GetById(@PathVariable int id) {
		return carService.GetById(id);
	}
	
	@PostMapping
	public CreateCarResponse add(@RequestBody CreateCarRequest createCarRequest) {
		return carService.add(createCarRequest);
	}
	
	@PutMapping
	public UpdateCarResponse update(@RequestBody UpdateCarRequest updateCarRequest) {
		return carService.update(updateCarRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable int id) {
		carService.delete(id);
	}
	

}
