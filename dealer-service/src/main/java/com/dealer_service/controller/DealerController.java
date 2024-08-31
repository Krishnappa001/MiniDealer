package com.dealer_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dealer_service.dto.DealerDTO;
import com.dealer_service.service.DealerService;

@RestController
@RequestMapping("/api/dealer")
public class DealerController {
	
	@Autowired
	private DealerService dealerService;
   
	@PostMapping("/save")
	public ResponseEntity<DealerDTO> saveDealer(@RequestBody DealerDTO dealerDTO)
	{
		DealerDTO saveDealer = dealerService.saveDealer(dealerDTO);
		return new ResponseEntity<>(saveDealer,HttpStatus.CREATED);
	}
	@GetMapping("/byId")
	public ResponseEntity<DealerDTO> getDealerById(@RequestParam("dealerId") Long dealerId)
	{
		return new ResponseEntity<>(dealerService.getDealer(dealerId),HttpStatus.OK);
	}
}
