package com.store_service.service;

import java.util.List;

import com.store_service.dto.StoreDTO;

public interface StoreService {
	public StoreDTO saveStore(StoreDTO storeDetailsDTO);
	 public StoreDTO updateStore(Long storeId, StoreDTO storeDetailsDTO);
	List<StoreDTO> getStores();
	public StoreDTO getStoreById(Long storeId);
  }
