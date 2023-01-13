package com.ozeratar.rentACar.business.requests.update;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
	private int id;
	private int carId;
	private int rentalDay;
	private double totalPrice;
	private LocalDateTime date;
	

}
