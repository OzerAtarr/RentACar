package com.ozeratar.rentACar.business.abstracts;

import java.util.List;

import com.ozeratar.rentACar.business.requests.create.CreateCarRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateCarRequest;
import com.ozeratar.rentACar.business.responses.create.CreateCarResponse;
import com.ozeratar.rentACar.business.responses.get.GetCarResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllCarsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateCarResponse;

public interface CarService {
	List<GetAllCarsResponse> getAll();
	GetCarResponse GetById(int id);
	CreateCarResponse add(CreateCarRequest createCarRequest);
	UpdateCarResponse update(UpdateCarRequest updateCarRequest);
	void delete (int id);
	

}
