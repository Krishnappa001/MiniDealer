package com.dealer_service.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealer_service.dao.DealerDAO;
import com.dealer_service.dto.DealerDTO;
import com.dealer_service.entity.Dealer;
import com.dealer_service.service.DealerService;
@Service
public class DealerServiceImpl implements DealerService{
  
	@Autowired
	private ModelMapper modelMapper;
    @Autowired
    private DealerDAO dealerDAO;
	@Override
	public DealerDTO saveDealer(DealerDTO dealerDTO) {
		
		Dealer dealer = modelMapper.map(dealerDTO, Dealer.class);
		
		Dealer savedDealer = dealerDAO.save(dealer);
		
		return modelMapper.map(savedDealer, DealerDTO.class);
	}
	@Override
	public DealerDTO getDealer(Long dealerId) {
	    return dealerDAO.findById(dealerId)
	        .map(dealer -> modelMapper.map(dealer, DealerDTO.class))
	        .orElseThrow(() -> new IllegalArgumentException("Dealer with ID " + dealerId + " not found"));
	}


}
