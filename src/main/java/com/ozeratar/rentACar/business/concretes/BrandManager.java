package com.ozeratar.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozeratar.rentACar.business.abstracts.BrandService;
import com.ozeratar.rentACar.business.constants.BusinessMessages;
import com.ozeratar.rentACar.business.requests.create.CreateBrandRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateBrandRequest;
import com.ozeratar.rentACar.business.responses.create.CreateBrandResponse;
import com.ozeratar.rentACar.business.responses.get.GetBrandResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllBrandsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateBrandResponse;
import com.ozeratar.rentACar.core.utilities.exceptions.BusinessException;
import com.ozeratar.rentACar.core.utilities.mapping.ModelMapperService;
import com.ozeratar.rentACar.dataAccess.BrandRepository;
import com.ozeratar.rentACar.entities.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager  implements BrandService{
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse()
				.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		return brandsResponse;
	}

	@Override
	public GetBrandResponse getById(int id) {
		checkIfBrandExists(id);
		GetBrandResponse response = new GetBrandResponse();
		Brand brand = brandRepository.findById(id).orElse(null);
		response.setId(brand.getId());
		response.setName(brand.getName());
		return response;
	}

	@Override
	public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
		checkIfBrandByName(createBrandRequest.getName());
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		Brand addedBrand =brandRepository.save(brand);
		CreateBrandResponse response = modelMapperService.forRequest().map(addedBrand, CreateBrandResponse.class);
		return response;
	}

	@Override
	public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
		checkIfBrandExists(updateBrandRequest.getId());
		checkIfBrandByName(updateBrandRequest.getName());
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		Brand updatedBrand = brandRepository.save(brand);
		UpdateBrandResponse response = modelMapperService.forResponse().map(updatedBrand, UpdateBrandResponse.class);
		return response;
	}

	@Override
	public void delete(int id) {
		checkIfBrandExists(id);
		brandRepository.deleteById(id);
		
	}

	private void checkIfBrandExists(int id) {
		Brand brand = this.brandRepository.findById(id).orElse(null);
		if(brand==null) {
			throw new BusinessException(BusinessMessages.BrandNoExists);
		}
	}
	
	private void checkIfBrandByName(String name) {
		Brand brand = this.brandRepository.findByName(name);
		if(brand!=null) {
			throw new BusinessException(BusinessMessages.BrandExists);
		}
	}
}
