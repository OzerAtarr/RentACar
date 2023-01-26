package com.ozeratar.rentACar.business.requests.update;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	@NotNull
	@NotEmpty
	private int id;
	private String plate;
	private int brandId;
	private int modelId;
	private int colorId;
	private String descriptoion;
	private double daily_price;
	private int state;


}
