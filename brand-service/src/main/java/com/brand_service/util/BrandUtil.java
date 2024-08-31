package com.brand_service.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BrandUtil {

    @Autowired
    private ObjectMapper objectMapper;
    
      
    public String jsonAsString(Object obj) {
        try {
            String json = objectMapper.writeValueAsString(obj);
            log.debug("MicroDealerUtil :: jsonAsString() - Object serialized to JSON successfully");
            return json;
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            log.error("MicroDealerUtil :: jsonAsString() - Error serializing object to JSON: {}", e.getMessage(), e);
            throw new IllegalStateException("Error serializing object to JSON", e);
        }
    }
    public  <D, E> E mapDTOToEntity(ModelMapper modelMapper, D dto, Class<E> entityClass) {
    	// map specific fields
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        return modelMapper.map(dto, entityClass);
    }

    public  <E, D> D mapEntityToDTO(ModelMapper modelMapper, E entity, Class<D> dtoClass) {
    	// map specific fields
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        return modelMapper.map(entity, dtoClass);
    }
    

	  public static double distance(double lat1, double lon1, double lat2, double lon2) {
	    double dLat = Math.toRadians(lat2 - lat1);
	    double dLon = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLon / 2) * Math.sin(dLon / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    return Constants.EARTH_RADIUS * c;
	  }
  
}
