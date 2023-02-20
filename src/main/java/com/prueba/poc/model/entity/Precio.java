package com.prueba.poc.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "precios")
@Data
public class Precio implements Serializable{

	private static final long serialVersionUID = -2285599753578458426L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
		
	@Column(name = "brand_id")
	private String brandId;
	
	@Column(name = "start_date")
	private LocalDateTime startDate;
	
	@Column(name = "end_date")
	private LocalDateTime endDate;
	
	@Column(name = "price_list")
	private Integer priceList;
	
	@Column(name = "product_id")	
	private Integer productId;
	
	@Column(name = "priority")	
	private Integer priority;
	
	@Column(name = "price")	
	private Double price;
	
	@Column(name = "curr")	
	private String curr;

}
