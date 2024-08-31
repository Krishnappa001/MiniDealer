package com.consumer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ConsumerDTO {
	private Long id;
	private String name;

	private String email;

	//private String deviceToken;
	
	private String vinNumber;
	
	private String location;

	private double locationLat;

	private double locationLong;

	private String mobileNo;

	private String osType;
	
	private String userType;

	private char userStatus;

}
