package com.ozeratar.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozeratar.rentACar.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
