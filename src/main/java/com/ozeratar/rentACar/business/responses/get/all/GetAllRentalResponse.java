package com.ozeratar.rentACar.business.responses.get.all;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRentalResponse {
	private int id;
	private int carId;
	private int rentalDay;
	private double totalPrice;
	private LocalDateTime date;

}