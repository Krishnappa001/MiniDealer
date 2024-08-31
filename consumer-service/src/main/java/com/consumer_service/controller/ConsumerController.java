package com.consumer_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consumer_service.dto.ConsumerDTO;
import com.consumer_service.service.ConsumerService;

@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
   
	@PostMapping("/save")
	public ResponseEntity<ConsumerDTO> saveDealer(@RequestBody ConsumerDTO consumerDTO)
	{
		ConsumerDTO saveConsumer = consumerService.saveConsumer(consumerDTO);
		return new ResponseEntity<>(saveConsumer,HttpStatus.CREATED);
	}
	@GetMapping("/byId")
	public ResponseEntity<ConsumerDTO> getConsumerById(@RequestParam("consumerId") Long consumerId)
	{
		return new ResponseEntity<>(consumerService.getConsumer(consumerId),HttpStatus.OK);
	}
}
