package com.consumer_service.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumer_service.dao.ConsumerDAO;
import com.consumer_service.dto.ConsumerDTO;
import com.consumer_service.entity.Consumer;
import com.consumer_service.service.ConsumerService;
@Service
public class ConsumerServiceImpl implements ConsumerService{
  
	@Autowired
	private ModelMapper modelMapper;
    @Autowired
    private ConsumerDAO consumerDAO;
	@Override
	public ConsumerDTO saveConsumer(ConsumerDTO dealerDTO) {
		
		Consumer dealer = modelMapper.map(dealerDTO, Consumer.class);
		
		Consumer savedDealer = consumerDAO.save(dealer);
		
		return modelMapper.map(savedDealer, ConsumerDTO.class);
	}
	@Override
	public ConsumerDTO getConsumer(Long consumerId) {
	    return consumerDAO.findById(consumerId)
	        .map(dealer -> modelMapper.map(dealer, ConsumerDTO.class))
	        .orElseThrow(() -> new IllegalArgumentException("Dealer with ID " + consumerId + " not found"));
	}


}
