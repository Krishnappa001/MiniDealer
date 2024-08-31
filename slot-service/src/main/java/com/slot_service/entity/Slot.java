package com.slot_service.entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SLOT_DTLS")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SLOT_ID")
    private Long id;

    @Column(name = "SLOT_DATE")
    private LocalDate date;
    
    @Column(name = "START_TIME")
    private LocalTime startTime;
    
    @Column(name = "END_TIME")
    private LocalTime endTime; 
    
    
  
}