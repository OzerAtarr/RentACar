	package com.ozeratar.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozeratar.rentACar.business.abstracts.CarService;
import com.ozeratar.rentACar.business.requests.create.CreateCarRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateCarRequest;
import com.ozeratar.rentACar.business.responses.create.CreateCarResponse;
import com.ozeratar.rentACar.business.responses.get.GetCarResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllCarsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateCarResponse;
import com.ozeratar.rentACar.core.utilities.mapping.ModelMapperService;
import com.ozeratar.rentACar.dataAccess.CarRepository;
import com.ozeratar.rentACar.entities.Car;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService{
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = carRepository.findAll();
		List<GetAllCarsResponse> carResponse = cars.stream().map(car -> this.modelMapperService.forResponse()
				.map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
		return carResponse;
	}

	@Override
	public GetCarResponse  GetById(int id) {
		Car car = carRepository.findById(id).orElse(null);
		GetCarResponse carResponse = modelMapperService.forResponse().map(car, GetCarResponse.class);
		
		return carResponse;
	}

	@Override
	public CreateCarResponse add(CreateCarRequest createCarRequest) {
		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
		Car addedCar = carRepository.save(car);
		CreateCarResponse response = modelMapperService.forResponse().map(addedCar, CreateCarResponse.class);
		return response;
	}

	@Override
	public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		Car updatedCar = carRepository.save(car);
		UpdateCarResponse response = modelMapperService.forResponse().map(updatedCar, UpdateCarResponse.class);
		return response;
	}

	@Override
	public void delete(int id) {
		carRepository.deleteById(id);
	}
	
}
