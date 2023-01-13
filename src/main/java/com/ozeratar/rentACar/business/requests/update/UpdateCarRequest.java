package com.ozeratar.rentACar.business.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	private int id;
	private String plate;
	private String brand;
	private String model;
	private String color;
	private String descriptoion;
	private double daily_price;
	private int state;


}
