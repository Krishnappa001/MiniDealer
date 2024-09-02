package com.store_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store_service.dto.APIResponse;
import com.store_service.dto.StoreDTO;
import com.store_service.service.StoreService;
import com.store_service.util.Constants;
import com.store_service.util.StoreUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeMasterService;

    @Autowired
    private StoreUtil util;
    
    @Value("${microservice.dealer-service.endpoints.endpoint.uri}")
    private String dealerEndpoint;

    @PostMapping(value="/add-store", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse<StoreDTO>> addStore(@RequestBody StoreDTO storeDetailsDTO) {
        log.info("StoreController::addStore() - Request body: {}", util.jsonAsString(storeDetailsDTO));
        
        StoreDTO savedStoreDTO = storeMasterService.saveStore(storeDetailsDTO);
        APIResponse<StoreDTO> response = APIResponse.<StoreDTO>builder()
                .status(Constants.SUCCESS)
                .build();
        
        if (savedStoreDTO != null) {
            log.info("StoreController::addStore() - Response: {}", util.jsonAsString(response));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            log.error("StoreController::addStore() - Internal server error while saving store");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateStore/{storeId}")
    public ResponseEntity<APIResponse<StoreDTO>> updateStore(
            @PathVariable Long storeId,
            @RequestBody StoreDTO storeDetailsDTO) {
        log.info("StoreController::updateStore() - Execution started for storeId: {}", storeId);
        
        StoreDTO updatedStore = storeMasterService.updateStore(storeId, storeDetailsDTO);
        
        if (updatedStore != null) {
            APIResponse<StoreDTO> response = APIResponse.<StoreDTO>builder()
                    .status(Constants.SUCCESS)
                    .build();
            log.info("StoreController::updateStore() - Response: {}", util.jsonAsString(response));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            log.error("StoreController::updateStore() - Store not found for storeId: {}", storeId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/allStores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StoreDTO>> getAllStores(){
        log.info("StoreController::getAllStores() - Execution started");
        
        List<StoreDTO> stores = storeMasterService.getStores();
        
        log.info("StoreController::getAllStores() - Response: {}", util.jsonAsString(stores));
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{storeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable Long storeId){
        log.info("StoreController::getStoreById() - Execution started");
        
        StoreDTO stores = storeMasterService.getStoreById(storeId);
        
        log.info("StoreController::getStoreById() - Response: {}", util.jsonAsString(stores));
        log.info("StoreController::getStoreById() - Response: dealer endpoint {}", util.jsonAsString(dealerEndpoint));
        
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }
    
    
    
}