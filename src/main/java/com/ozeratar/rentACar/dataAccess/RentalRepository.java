package com.ozeratar.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozeratar.rentACar.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer>{

}
