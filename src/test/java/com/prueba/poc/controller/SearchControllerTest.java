package com.prueba.poc.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.SwaggerCodeGen.model.PriceResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class SearchControllerTest {

	@Autowired
	private WebTestClient client;
		
	@Test
	void testSearch1() {
		client.get().uri("/v1/price?brandId=1&productId=35455&startDate=2020-06-14T10:00:00.000Z").exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody(PriceResult.class)
		.consumeWith(response -> {
			PriceResult precio = response.getResponseBody();
			assertNotNull(precio);
			assertEquals(OffsetDateTime.of(LocalDateTime.of(2020, 06, 14, 0, 0), ZoneOffset.UTC), precio.getStartDate());
			assertEquals(35.5, precio.getPrice());
		});
	}
	
	@Test
	void testSearch2() {
		client.get().uri("/v1/price?brandId=1&productId=35455&startDate=2020-06-16T10:00:00.000Z").exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody(PriceResult.class)
		.consumeWith(response -> {
			PriceResult precio = response.getResponseBody();
			assertNotNull(precio);
			assertEquals(OffsetDateTime.of(LocalDateTime.of(2020, 06, 15, 16, 0), ZoneOffset.UTC), precio.getStartDate());
			assertEquals(38.95, precio.getPrice());
		});
	}
	
	@Test
	void testSearch3() {
		client.get().uri("/v1/price?brandId=1&productId=35455&startDate=2020-06-21T10:00:00.000Z").exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody(PriceResult.class)
		.consumeWith(response -> {
			PriceResult precio = response.getResponseBody();
			assertNotNull(precio);			
			assertEquals(OffsetDateTime.of(LocalDateTime.of(2020, 06, 15, 16, 0), ZoneOffset.UTC), precio.getStartDate());
			assertEquals(38.95, precio.getPrice());
		});
	}
	
	@Test
	void testSearch4() {
		client.get().uri("/v1/price?brandId=1&productId=35455&startDate=2020-06-15T10:00:00.000Z").exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody(PriceResult.class)
		.consumeWith(response -> {
			PriceResult precio = response.getResponseBody();
			assertNotNull(precio);
			assertEquals(OffsetDateTime.of(LocalDateTime.of(2020, 06, 15, 0, 0), ZoneOffset.UTC), precio.getStartDate());
			assertEquals(30.5, precio.getPrice());
		});
	}
	
	@Test
	void testSearch5() {
		client.get().uri("/v1/price?brandId=1&productId=35455&startDate=2020-06-16T10:00:00.000Z").exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody(PriceResult.class)
		.consumeWith(response -> {
			PriceResult precio = response.getResponseBody();
			assertNotNull(precio);
			assertEquals(OffsetDateTime.of(LocalDateTime.of(2020, 06, 15, 16, 0), ZoneOffset.UTC), precio.getStartDate());
			assertEquals(38.95, precio.getPrice());
		});		
	}
}
