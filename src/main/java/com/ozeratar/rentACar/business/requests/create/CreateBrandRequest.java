package com.ozeratar.rentACar.business.requests.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
	@Size(min = 2, max = 50)
	@NotBlank
	@NotEmpty
	private String name;

}
