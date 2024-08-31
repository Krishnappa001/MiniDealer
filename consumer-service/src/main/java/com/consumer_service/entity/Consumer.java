package com.consumer_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "CONSUMER_DTLS")
public class Consumer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONSUMER_ID")
	private Long dealerId;

	@Column(name = "NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;

	/*
	 * @Column(name = "DEVICE_TOKEN", length = 163) private String deviceToken;
	 */

	@Column(name = "VIN_NUMBER", length = 17, nullable = true)
	private String vinNumber;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "LOCATION_LATITUDE")
	private double locationLat;

	@Column(name = "LOCATION_LONGITUDE")
	private double locationLong;

	@Column(name = "MOBILE_NO", length = 16)
	private String mobileNo;

	@Column(name = "OS_TYPE", length = 10)
	private String osType;
	
	@Column(name = "USER_TYPE", length = 10, nullable = false, updatable = false)
	private String userType;

	@Column(name = "USER_STATUS", length = 1, columnDefinition = "char default 'A'")
	private char userStatus;

}
