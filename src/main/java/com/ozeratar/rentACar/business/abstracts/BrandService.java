package com.ozeratar.rentACar.business.abstracts;

import java.util.List;

import com.ozeratar.rentACar.business.requests.create.CreateBrandRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateBrandRequest;
import com.ozeratar.rentACar.business.responses.create.CreateBrandResponse;
import com.ozeratar.rentACar.business.responses.get.GetBrandResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllBrandsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetBrandResponse getById(int id);
	CreateBrandResponse add(CreateBrandRequest createBrandRequest);
	UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest);
	void delete (int id);
	

}
