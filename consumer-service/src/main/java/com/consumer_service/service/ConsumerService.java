package com.consumer_service.service;

import com.consumer_service.dto.ConsumerDTO;

public interface ConsumerService {
public ConsumerDTO getConsumer(Long consumerId);
public ConsumerDTO saveConsumer(ConsumerDTO consumerDTO);
}
