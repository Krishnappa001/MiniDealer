package com.store_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

	private Long id;
	private String name;
	private Double latitude;
	private Double longitude;
	private String address;

}
