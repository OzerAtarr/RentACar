package com.ozeratar.rentACar.business.abstracts;

import java.util.List;

import com.ozeratar.rentACar.business.responses.create.CreateRentalResponse;
import com.ozeratar.rentACar.business.responses.get.GetRentalResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllRentalResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateRentalResponse;

public interface RentalService {
	List<GetAllRentalResponse> getAll(GetAllRentalResponse getAllRentalResponse);
	GetRentalResponse getById(int id);
	CreateRentalResponse add(CreateRentalResponse createRentalResponse);
	UpdateRentalResponse update(UpdateRentalResponse updateRentalResponse);
	void delete(int id);
}
	
