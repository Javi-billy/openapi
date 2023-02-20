package com.prueba.poc.controller;

import java.time.OffsetDateTime;

import org.SwaggerCodeGen.api.PriceApi;
import org.SwaggerCodeGen.model.PriceResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.poc.service.SearchService;

@RestController
public class PruebaController implements PriceApi {

	private SearchService searchService;

	public PruebaController(final SearchService searchService) {
		this.searchService = searchService;
	}

	@Override
	public ResponseEntity<PriceResult> getFilterPrices(OffsetDateTime startDate, Integer productId, String brandId) {		
		return ResponseEntity.ok(searchService.searchPricesCriteria(startDate.toLocalDateTime(), productId, brandId));
	}	
}
