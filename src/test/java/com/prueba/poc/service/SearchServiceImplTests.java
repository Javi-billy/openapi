package com.prueba.poc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.SwaggerCodeGen.model.PriceResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.poc.mapper.ResultMapper;
import com.prueba.poc.model.repository.PrecioDao;
import com.prueba.poc.service.impl.SearchServiceImpl;

@SpringBootTest
class SearchServiceImplTests {

	@Autowired
	private PrecioDao repository;

	@Autowired
	private ResultMapper mapper;

	private static SearchService searchService;

	private static Integer productId = 35455;
	private static String brandId = "1";

	@BeforeEach
	void beforeEach() {
		searchService = new SearchServiceImpl(repository, mapper);
	}

	@ParameterizedTest
	@CsvSource({ "2020,6,14,10" })
	void test1(Integer year, Integer mounth, Integer day, Integer hour) {

		// GIVEN
		LocalDateTime startDateTime = LocalDateTime.of(year, mounth, day, hour, 0);

		PriceResult precio = searchService.searchPricesCriteria(startDateTime, productId, brandId);

		PriceResult precioExpected = new PriceResult();
		precioExpected.setBrandId(brandId);
		precioExpected.setProductId(productId);
		LocalDateTime startDateTimeExpected = LocalDateTime.of(year, mounth, day, 0, 0);
		precioExpected.setStartDate(OffsetDateTime.of(startDateTimeExpected, ZoneOffset.UTC));
		precioExpected.setPrice(Double.valueOf(35.5));
		precioExpected.setPriceList(1);
		
		assertEquals(precioExpected, precio);

	}

	@ParameterizedTest
	@CsvSource({ "2020,6,16,10" })
	void test2(Integer year, Integer mounth, Integer day, Integer hour) {
		// GIVEN
		LocalDateTime startDateTime = LocalDateTime.of(year, mounth, day, hour, 0);

		PriceResult precioExpected = new PriceResult();
		precioExpected.setBrandId(brandId);
		precioExpected.setProductId(productId);
		LocalDateTime startDateTimeExpected = LocalDateTime.of(year, mounth, 15, 16, 0);
		precioExpected.setStartDate(OffsetDateTime.of(startDateTimeExpected, ZoneOffset.UTC));
		precioExpected.setPrice(Double.valueOf(38.95));
		precioExpected.setPriceList(4);

		PriceResult precio = searchService.searchPricesCriteria(startDateTime, productId, brandId);
		
		assertEquals(precioExpected, precio);
	}

	@ParameterizedTest
	@CsvSource({ "2020,6,21,10" })
	void test3(Integer year, Integer mounth, Integer day, Integer hour) {

		// GIVEN
		LocalDateTime startDateTime = LocalDateTime.of(year, mounth, day, hour, 0);

		PriceResult precioExpected = new PriceResult();
		precioExpected.setBrandId(brandId);
		precioExpected.setProductId(productId);
		LocalDateTime startDateTimeExpected = LocalDateTime.of(year, mounth, 15, 16, 0);
		precioExpected.setStartDate(OffsetDateTime.of(startDateTimeExpected, ZoneOffset.UTC));
		precioExpected.setPrice(Double.valueOf(38.95));
		precioExpected.setPriceList(4);

		PriceResult precio = searchService.searchPricesCriteria(startDateTime, productId, brandId);

		assertEquals(precioExpected, precio);		
	}

	@ParameterizedTest
	@CsvSource({ "2020,6,15,10" })
	void test4(Integer year, Integer mounth, Integer day, Integer hour) {

		// GIVEN
		LocalDateTime startDateTime = LocalDateTime.of(year, mounth, day, hour, 0);

		PriceResult precioExpected = new PriceResult();
		precioExpected.setBrandId(brandId);
		precioExpected.setProductId(productId);
		LocalDateTime startDateTimeExpected = LocalDateTime.of(year, mounth, 15, 0, 0);
		precioExpected.setStartDate(OffsetDateTime.of(startDateTimeExpected, ZoneOffset.UTC));
		precioExpected.setPrice(Double.valueOf(30.5));
		precioExpected.setPriceList(3);

		PriceResult precio = searchService.searchPricesCriteria(startDateTime, productId, brandId);

		assertNotNull(precio);

		assertEquals(precioExpected.getStartDate(), precio.getStartDate());
		assertEquals(precioExpected.getPrice(), precio.getPrice());
		assertEquals(precioExpected.getPriceList(), precio.getPriceList());
	}

	@ParameterizedTest
	@CsvSource({ "2020,6,16,10" })
	void test5(Integer year, Integer mounth, Integer day, Integer hour) {

		// GIVEN
		LocalDateTime startDateTime = LocalDateTime.of(year, mounth, day, hour, 0);

		PriceResult precioExpected = new PriceResult();
		precioExpected.setBrandId(brandId);
		precioExpected.setProductId(productId);
		LocalDateTime startDateTimeExpected = LocalDateTime.of(year, mounth, 15, 16, 0);
		precioExpected.setStartDate(OffsetDateTime.of(startDateTimeExpected, ZoneOffset.UTC));		
		precioExpected.setPrice(Double.valueOf(38.95));
		precioExpected.setPriceList(4);

		PriceResult precio = searchService.searchPricesCriteria(startDateTime, productId, brandId);

		assertEquals(precioExpected, precio);
	}
}
