package com.ozeratar.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozeratar.rentACar.business.abstracts.RentalService;
import com.ozeratar.rentACar.business.responses.create.CreateRentalResponse;
import com.ozeratar.rentACar.business.responses.get.GetRentalResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllRentalResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateRentalResponse;
import com.ozeratar.rentACar.core.utilities.mapping.ModelMapperService;
import com.ozeratar.rentACar.dataAccess.RentalRepository;
import com.ozeratar.rentACar.entities.Rental;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
	private RentalRepository rentalRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllRentalResponse> getAll(GetAllRentalResponse getAllRentalResponse) {
		List<Rental> rentals = rentalRepository.findAll();
		List<GetAllRentalResponse> rentalResponse = rentals.stream().map(rental -> this.modelMapperService.forResponse()
				.map(rentals, GetAllRentalResponse.class)).collect(Collectors.toList());
		return rentalResponse;
	}

	@Override
	public GetRentalResponse getById(int id) {
		Rental rental = rentalRepository.findById(id).orElse(null);
		GetRentalResponse response = modelMapperService.forResponse().map(rental, GetRentalResponse.class);
		return response;
	}

	@Override
	public CreateRentalResponse add(CreateRentalResponse createRentalResponse) {
		Rental rental = modelMapperService.forRequest().map(createRentalResponse, Rental.class);
		Rental addRental = rentalRepository.save(rental);
		CreateRentalResponse response = modelMapperService.forResponse().map(addRental, CreateRentalResponse.class);
		return response;
	}

	@Override
	public UpdateRentalResponse update(UpdateRentalResponse updateRentalResponse) {
		Rental rental = modelMapperService.forRequest().map(updateRentalResponse, Rental.class);
		Rental addedRental = rentalRepository.save(rental);
		UpdateRentalResponse response = modelMapperService.forResponse().map(addedRental, UpdateRentalResponse.class);
		return response;
	}

	@Override
	public void delete(int id) {
		rentalRepository.deleteById(id);
	}
	
}
