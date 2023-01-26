package com.ozeratar.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozeratar.rentACar.business.abstracts.BrandService;
import com.ozeratar.rentACar.business.abstracts.CarService;
import com.ozeratar.rentACar.business.abstracts.ColorService;
import com.ozeratar.rentACar.business.abstracts.ModelService;
import com.ozeratar.rentACar.business.constants.BusinessMessages;
import com.ozeratar.rentACar.business.requests.create.CreateCarRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateCarRequest;
import com.ozeratar.rentACar.business.responses.create.CreateCarResponse;
import com.ozeratar.rentACar.business.responses.get.GetCarResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllCarsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateCarResponse;
import com.ozeratar.rentACar.core.utilities.exceptions.BusinessException;
import com.ozeratar.rentACar.core.utilities.mapping.ModelMapperService;
import com.ozeratar.rentACar.dataAccess.CarRepository;
import com.ozeratar.rentACar.entities.Car;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	private BrandService brandService;
	private ModelService modelService;
	private ColorService colorService;

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = carRepository.findAll();
		List<GetAllCarsResponse> carResponse = cars.stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.collect(Collectors.toList());
		return carResponse;
	}

	@Override
	public GetCarResponse getById(int id) {
		checkIfCarExists(id);
		Car car = carRepository.findById(id).orElse(null);
		GetCarResponse carResponse = modelMapperService.forResponse().map(car, GetCarResponse.class);

		return carResponse;
	}

	@Override
	public CreateCarResponse add(CreateCarRequest createCarRequest) {
		checkIfCarExistsByPlate(createCarRequest.getPlate());
		checkIfBrandExists(createCarRequest.getBrandId());
		checkIfColorExists(createCarRequest.getColorId());
		checkIfModelExists(createCarRequest.getModelId());
		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
		Car addedCar = carRepository.save(car);
		CreateCarResponse response = modelMapperService.forResponse().map(addedCar, CreateCarResponse.class);
		return response;
	}

	@Override
	public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
		checkIfCarExists(updateCarRequest.getId());
		checkIfCarExistsByPlate(updateCarRequest.getPlate());
		checkIfBrandExists(updateCarRequest.getBrandId());
		checkIfColorExists(updateCarRequest.getColorId());
		checkIfModelExists(updateCarRequest.getModelId());
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		Car updatedCar = carRepository.save(car);
		UpdateCarResponse response = modelMapperService.forResponse().map(updatedCar, UpdateCarResponse.class);
		return response;
	}

	@Override
	public void delete(int id) {
		checkIfCarExists(id);
		carRepository.deleteById(id);
	}

	private void checkIfCarExists(int id) {
		Car car = this.carRepository.findById(id).orElse(null);
		if (car == null) {
			throw new BusinessException(BusinessMessages.CarNoExists);
		}
	}

	private void checkIfCarExistsByPlate(String plate) {
		Car car = this.carRepository.findByPlate(plate);
		if (car != null) {
			throw new BusinessException(BusinessMessages.CarExists);
		}
	}

	private void checkIfBrandExists(int brandId) {
		brandService.getById(brandId);
	}

	private void checkIfModelExists(int modelId) {
		modelService.getById(modelId);
	}

	private void checkIfColorExists(int colorId) {
		colorService.getById(colorId);
	}
	
	

}
