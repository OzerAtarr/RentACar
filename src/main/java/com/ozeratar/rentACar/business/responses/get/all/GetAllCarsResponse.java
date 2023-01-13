package com.ozeratar.rentACar.business.responses.get.all;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {
	private int id;
	private String plate;
	private String brandName;
	private String modelName;
	private String colorName;
	private String descriptoion;
	private double daily_price;
	private int state;

}
