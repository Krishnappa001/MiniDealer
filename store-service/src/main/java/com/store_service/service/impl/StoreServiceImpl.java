package com.store_service.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store_service.dao.StoreDAO;
import com.store_service.dto.StoreDTO;
import com.store_service.entity.Store;
import com.store_service.service.StoreService;
import com.store_service.util.StoreUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreDAO dao;
    private final ModelMapper modelMapper;
    private final StoreUtil util;

    
    @Autowired
    public StoreServiceImpl(StoreDAO dao, StoreUtil util, ModelMapper modelMapper) {
        this.dao = dao;
        this.util = util;
        this.modelMapper = modelMapper;
    }
   
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public StoreDTO saveStore(StoreDTO storeDetailsDTO) {
        log.info("StoreMasterServiceImpl:saveStore execution started.");
        Store storeDetails = util.mapDTOToEntity(modelMapper, storeDetailsDTO, Store.class);
        Store savedStore = dao.save(storeDetails);
        log.debug("StoreMasterServiceImpl:saveStore received response from Database {}",
                util.jsonAsString(savedStore));
        return util.mapEntityToDTO(modelMapper, savedStore, StoreDTO.class);
    }


    @Override
    @Transactional
    public StoreDTO updateStore(Long storeId, StoreDTO storeDetailsDTO) {
        log.info("StoreMasterServiceImpl:updateStore execution started.");
        
        return dao.findById(storeId)
            .map(existingStore -> updateExistingStore(existingStore, storeDetailsDTO))
            .map(dao::save)
            .map(updatedStore -> {
                log.info("StoreMasterServiceImpl:updateStore response {}", util.jsonAsString(updatedStore));
                return util.mapEntityToDTO(modelMapper, updatedStore, StoreDTO.class);
            })
            .orElse(null);
    }

    private Store updateExistingStore(Store existingStore, StoreDTO storeDetailsDTO) {
        Optional.ofNullable(storeDetailsDTO.getName()).ifPresent(existingStore::setName);
        Optional.ofNullable(storeDetailsDTO.getLatitude()).ifPresent(existingStore::setLatitude);
        Optional.ofNullable(storeDetailsDTO.getLongitude()).ifPresent(existingStore::setLongitude);
        Optional.ofNullable(storeDetailsDTO.getAddress()).ifPresent(existingStore::setAddress);
        return existingStore;
    }
    


	@Override
    public List<StoreDTO> getStores() {
        log.info("StoreMasterServiceImpl:getAllActiveStores execution started.");

        // Fetch all store entities
        List<Store> stores = dao.findAll();

        // Map each Store entity to StoreDTO
        List<StoreDTO> storesList = stores.stream()
                .map(store -> util.mapEntityToDTO(modelMapper, store, StoreDTO.class))
                .collect(Collectors.toList());

        // Log the response as JSON
        log.info("StoreMasterServiceImpl:getAllActiveStores response {}", util.jsonAsString(storesList));

        return storesList;
    }


	@Override
	public StoreDTO getStoreById(Long storeId) {
	    return dao.findById(storeId)
	        .map(store -> util.mapEntityToDTO(modelMapper, store, StoreDTO.class))
	        .orElseThrow(() -> new IllegalArgumentException("Store with ID " + storeId + " not found"));
	}


}
