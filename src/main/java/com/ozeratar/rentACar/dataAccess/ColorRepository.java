package com.ozeratar.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozeratar.rentACar.entities.Color;

public interface ColorRepository extends JpaRepository<Color, Integer>{
	Color findByName(String name);
}
