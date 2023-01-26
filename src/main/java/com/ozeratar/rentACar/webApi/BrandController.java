package com.ozeratar.rentACar.webApi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozeratar.rentACar.business.abstracts.BrandService;
import com.ozeratar.rentACar.business.requests.create.CreateBrandRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateBrandRequest;
import com.ozeratar.rentACar.business.responses.create.CreateBrandResponse;
import com.ozeratar.rentACar.business.responses.get.GetBrandResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllBrandsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateBrandResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {
	private BrandService brandService;
	
	@GetMapping
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	
	@PostMapping
	public CreateBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
		return brandService.add(createBrandRequest);
	}
	
	@PutMapping
	public UpdateBrandResponse update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
		return brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable int  id) {
		brandService.delete(id);
	}
	

}
