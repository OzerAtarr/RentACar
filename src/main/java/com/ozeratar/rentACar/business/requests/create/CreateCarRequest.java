package com.ozeratar.rentACar.business.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	private String plate;
	private int brandId;
	private int modelId;
	private int colorId;
	private String descriptoion;
	private double daily_price;
	private int state;

}
