package com.ozeratar.rentACar.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozeratar.rentACar.business.abstracts.RentalService;
import com.ozeratar.rentACar.business.responses.create.CreateRentalResponse;
import com.ozeratar.rentACar.business.responses.get.GetRentalResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllRentalResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateRentalResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalController {
	private RentalService rentalService;
	
	@GetMapping
	public List<GetAllRentalResponse> getAll(GetAllRentalResponse getAllRentalResponse){
		return rentalService.getAll(getAllRentalResponse);
	}
	
	@GetMapping("/{id}")
	public GetRentalResponse getById(GetRentalResponse getRentalResponse) {
		return rentalService.getById(getRentalResponse);
	}
	
	@PostMapping
	public CreateRentalResponse add(@RequestBody CreateRentalResponse createRentalResponse) {
		return rentalService.add(createRentalResponse);
	}
	
	@PutMapping
	public UpdateRentalResponse update(@RequestBody UpdateRentalResponse updateRentalResponse) {
		return rentalService.update(updateRentalResponse);
	}
	
	@DeleteMapping("/{id}")
	public void delete(int id) {
		rentalService.delete(id);
	}

}
