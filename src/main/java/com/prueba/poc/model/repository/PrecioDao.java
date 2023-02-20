package com.prueba.poc.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prueba.poc.model.entity.Precio;

public interface PrecioDao extends CrudRepository<Precio, Long>{		
	
	List<Precio> findByProductIdAndBrandId(Integer id, String brandId);

}
