package com.dealer_service.service;

import com.dealer_service.dto.DealerDTO;

public interface DealerService {
public DealerDTO saveDealer(DealerDTO dealerDTO);
public DealerDTO getDealer(Long dealerId);
}
