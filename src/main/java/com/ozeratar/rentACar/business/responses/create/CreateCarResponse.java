package com.ozeratar.rentACar.business.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarResponse {
	private int id;
	private String plate;
	private String brandName;
	private String modelName;
	private String colorName;
	private String descriptoion;
	private double daily_price;
	private int state;


}
