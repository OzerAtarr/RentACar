package com.ozeratar.rentACar.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarResponse {
	private int id;
	private int state;
	private String plate;
	private int brandId;
	private int modelId;
	private int colorId;
	private String description;
	private double daily_price;

}
