package com.prueba.poc.mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.SwaggerCodeGen.model.PriceResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;

import com.prueba.poc.model.entity.Precio;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ResultMapper {

	@Mapping(source = "startDate", target = "startDate", qualifiedByName = "convertDates")
	PriceResult mapToPrecioResponse(Precio precio);
	
	@Named("convertDates")
	default OffsetDateTime convertDates(LocalDateTime dateTime) {		
		ZoneOffset offset = ZoneOffset.UTC;
		return OffsetDateTime.of(dateTime, offset);
	}
	
}
