package com.slot_service.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlotDTO {

	private Long id;
	private LocalDate date; 
	private LocalTime startTime;
	private LocalTime endTime; 

}
