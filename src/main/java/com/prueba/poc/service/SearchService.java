package com.prueba.poc.service;

import java.time.LocalDateTime;

import org.SwaggerCodeGen.model.PriceResult;

public interface SearchService {

	PriceResult searchPricesCriteria(LocalDateTime startDate, Integer productId, String brandId);

}
