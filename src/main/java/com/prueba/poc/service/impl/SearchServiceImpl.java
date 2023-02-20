package com.prueba.poc.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.SwaggerCodeGen.model.PriceResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.poc.mapper.ResultMapper;
import com.prueba.poc.model.entity.Precio;
import com.prueba.poc.model.repository.PrecioDao;
import com.prueba.poc.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
	
	private PrecioDao repository;
	
	private ResultMapper mapper;

	public SearchServiceImpl(final PrecioDao repository, final ResultMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	@Transactional(readOnly = true)
	public PriceResult searchPricesCriteria(LocalDateTime startDate, Integer productId, String brandId) {
		List<Precio> precios = repository.findByProductIdAndBrandId(productId, brandId);

		Precio precio = precios.stream()
				.filter(p -> startDate.isEqual(p.getStartDate()) || startDate.isEqual(p.getEndDate())
						|| (startDate.isAfter(p.getStartDate()) && startDate.isBefore(p.getEndDate())))
				.sorted((Precio s1, Precio s2) -> s2.getPriority() - s1.getPriority())				
				.findFirst()
				.orElse(new Precio());				
		return mapper.mapToPrecioResponse(precio);
	}
}
