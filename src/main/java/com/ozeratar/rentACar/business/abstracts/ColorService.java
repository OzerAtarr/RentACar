package com.ozeratar.rentACar.business.abstracts;

import java.util.List;

import com.ozeratar.rentACar.business.requests.create.CreateColorRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateColorRequest;
import com.ozeratar.rentACar.business.responses.create.CreateColorResponse;
import com.ozeratar.rentACar.business.responses.get.GetColorResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllColorsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateColorResponse;

public interface ColorService {
	List<GetAllColorsResponse> getAll();
	GetColorResponse getById(int id);
	CreateColorResponse add(CreateColorRequest createColorRequest);
	UpdateColorResponse update(UpdateColorRequest updateColorRequest);
	void delete(int id);

}