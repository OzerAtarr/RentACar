package com.ozeratar.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozeratar.rentACar.entities.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

}
