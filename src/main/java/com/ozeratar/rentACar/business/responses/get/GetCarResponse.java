package com.ozeratar.rentACar.business.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
	private int id;
	private String plate;
	private int brandId;
	private int modelId;
	private int colorId;
	private String descriptoion;
	private double daily_price;
	private int state;
	

}
