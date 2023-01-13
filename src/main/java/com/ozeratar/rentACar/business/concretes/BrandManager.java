package com.ozeratar.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ozeratar.rentACar.business.abstracts.BrandService;
import com.ozeratar.rentACar.business.requests.create.CreateBrandRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateBrandRequest;
import com.ozeratar.rentACar.business.responses.create.CreateBrandResponse;
import com.ozeratar.rentACar.business.responses.get.GetBrandResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllBrandsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateBrandResponse;
import com.ozeratar.rentACar.dataAccess.BrandRepository;
import com.ozeratar.rentACar.entities.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager  implements BrandService{
	private BrandRepository brandRepository;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		List<Brand> brands = brandRepository.findAll();
		
		for (Brand brand : brands) {
			GetAllBrandsResponse response = new GetAllBrandsResponse();
			response.setId(brand.getId());
			response.setName(brand.getName());
			
			brandsResponse.add(response);
		}
		return brandsResponse;
	}

	@Override
	public GetBrandResponse getById(int id) {
		GetBrandResponse response = new GetBrandResponse();
		Brand brand = brandRepository.findById(id).orElse(null);
		response.setId(brand.getId());
		response.setName(brand.getName());
		return response;
	}

	@Override
	public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
		CreateBrandResponse response = new CreateBrandResponse();
		Brand brand = new Brand();
		System.out.println(createBrandRequest.getName());
		brand.setName(createBrandRequest.getName());
		
		brandRepository.save(brand);
		response.setId(brand.getId());
		response.setName(brand.getName());
		
		return response;
	}

	@Override
	public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
		UpdateBrandResponse response = new UpdateBrandResponse();
		Brand brand = brandRepository.findById(updateBrandRequest.getId()).orElse(null);
		
		brand.setName(updateBrandRequest.getName());
		brandRepository.save(brand);
		response.setId(brand.getId());
		response.setName(brand.getName());
		return response;
	}

	@Override
	public void delete(int id) {
		brandRepository.deleteById(id);
		
	}

	

}
