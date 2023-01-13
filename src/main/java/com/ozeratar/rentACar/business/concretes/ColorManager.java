package com.ozeratar.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ozeratar.rentACar.business.abstracts.ColorService;
import com.ozeratar.rentACar.business.requests.create.CreateColorRequest;
import com.ozeratar.rentACar.business.requests.update.UpdateColorRequest;
import com.ozeratar.rentACar.business.responses.create.CreateColorResponse;
import com.ozeratar.rentACar.business.responses.get.GetColorResponse;
import com.ozeratar.rentACar.business.responses.get.all.GetAllColorsResponse;
import com.ozeratar.rentACar.business.responses.update.UpdateColorResponse;
import com.ozeratar.rentACar.dataAccess.ColorRepository;
import com.ozeratar.rentACar.entities.Color;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService{
	private ColorRepository colorRepository;

	@Override
	public List<GetAllColorsResponse> getAll() {
		List<GetAllColorsResponse> colorsResponse = new ArrayList<GetAllColorsResponse>();
		List<Color> colors = colorRepository.findAll();
		
		for (Color color : colors) {
			GetAllColorsResponse response = new GetAllColorsResponse();
			response.setId(color.getId());
			response.setName(color.getName());
			
			colorsResponse.add(response);
		}
		return colorsResponse;
	}

	@Override
	public GetColorResponse getById(int id) {
		GetColorResponse response = new GetColorResponse();
		Color color = colorRepository.findById(id).orElse(null);
		response.setId(color.getId());
		response.setName(color.getName());
		
		return response;
	}

	@Override
	public CreateColorResponse add(CreateColorRequest createColorRequest) {
		CreateColorResponse response = new CreateColorResponse();
		Color color = new Color();
		color.setName(createColorRequest.getName());
		
		colorRepository.save(color);
		response.setId(color.getId());
		response.setName(color.getName());
		
		return response;
	}

	@Override
	public UpdateColorResponse update(UpdateColorRequest updateColorRequest) {
		UpdateColorResponse response = new UpdateColorResponse();
		Color color = colorRepository.findById(updateColorRequest.getId()).orElse(null);
		
		color.setName(updateColorRequest.getName());
		colorRepository.save(color);
		response.setId(color.getId());
		response.setName(color.getName());
		return response;
	}

	@Override
	public void delete(int id) {
		colorRepository.deleteById(id);
	}


}
