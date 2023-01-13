package com.ozeratar.rentACar.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozeratar.rentACar.business.abstracts.ColorService;
import com.ozeratar.rentACar.business.requests.create.CreateColorRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateColorRequest;
import com.ozeratar.rentACar.business.responses.create.CreateColorResponse;
import com.ozeratar.rentACar.business.responses.get.GetColorResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllColorsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateColorResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/colors")
@AllArgsConstructor
public class ColorController {
	private ColorService colorService;
	
	@GetMapping
	public List<GetAllColorsResponse> getAll(){
		return colorService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetColorResponse getById(@PathVariable int id) {
		return colorService.getById(id);
	}
	
	@PostMapping
	public CreateColorResponse add(@RequestBody CreateColorRequest createColorRequest) {
		return colorService.add(createColorRequest);
	}
	
	@PutMapping
	public UpdateColorResponse update(@RequestBody UpdateColorRequest updateColorRequest) {
		return colorService.update(updateColorRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		colorService.delete(id);
	}
	

}
