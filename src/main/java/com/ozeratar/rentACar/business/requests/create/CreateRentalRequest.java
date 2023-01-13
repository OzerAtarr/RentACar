package com.ozeratar.rentACar.business.requests.create;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
	private int carId;
	private int rentalDay;
	private double totalPrice;
	private LocalDateTime date;


}
