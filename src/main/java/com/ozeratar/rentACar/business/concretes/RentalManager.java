package com.ozeratar.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import com.ozeratar.rentACar.business.abstracts.RentalService;
import com.ozeratar.rentACar.business.responses.create.CreateRentalResponse;
import com.ozeratar.rentACar.business.responses.get.GetRentalResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllRentalResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateRentalResponse;
import com.ozeratar.rentACar.dataAccess.RentalRepository;
import com.ozeratar.rentACar.entities.Rental;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
	private RentalRepository rentalRepository;

	@Override
	public List<GetAllRentalResponse> getAll(GetAllRentalResponse getAllRentalResponse) {
		List<GetAllRentalResponse> rentalResponse = new ArrayList<GetAllRentalResponse>();
		List<Rental> rentals = rentalRepository.findAll();

		for (Rental rental : rentals) {
			GetAllRentalResponse response = new GetAllRentalResponse();
			response.setId(rental.getId());
			response.setDate(rental.getDate());
			response.setCarId(rental.getCar().getId());
			response.setRentalDay(rental.getRentalDay());
			response.setTotalPrice(rental.getTotalPrice());
			
			rentalResponse.add(response);
		}
		return rentalResponse;
	}

	@Override
	public GetRentalResponse getById(GetRentalResponse getRentalResponse) {
		GetRentalResponse response = new GetRentalResponse();
		Rental rental = new Rental();
		response.setId(rental.getId());
		response.setCarId(rental.getCar().getId());
		response.setDate(rental.getDate());
		response.setRentalDay(rental.getRentalDay());
		response.setTotalPrice(rental.getTotalPrice());
		return response;
	}

	@Override
	public CreateRentalResponse add(CreateRentalResponse createRentalResponse) {
		CreateRentalResponse response = new CreateRentalResponse();
		Rental rental = new Rental();
		response.setCarId(createRentalResponse.getCarId());
		response.setDate(createRentalResponse.getDate());
		response.setRentalDay(createRentalResponse.getRentalDay());
		response.setTotalPrice(createRentalResponse.getTotalPrice());
		
		return response;
	}

	@Override
	public UpdateRentalResponse update(UpdateRentalResponse updateRentalResponse) {
		UpdateRentalResponse response = new UpdateRentalResponse();
		Rental rental = rentalRepository.findById(updateRentalResponse.getId()).orElse(null);
		
		response.setCarId(updateRentalResponse.getCarId());
		response.setDate(updateRentalResponse.getDate());
		response.setRentalDay(updateRentalResponse.getRentalDay());
		response.setTotalPrice(updateRentalResponse.getTotalPrice());
		
		rentalRepository.save(rental);
		
		response.setId(rental.getId());
		response.setCarId(rental.getCar().getId());
		response.setDate(rental.getDate());
		response.setRentalDay(rental.getRentalDay());
		response.setTotalPrice(rental.getTotalPrice());
		return response;
	}

	@Override
	public void delete(int id) {
		rentalRepository.deleteById(id);
	}

}
