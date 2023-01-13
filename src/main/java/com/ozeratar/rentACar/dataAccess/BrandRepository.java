package com.ozeratar.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozeratar.rentACar.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
