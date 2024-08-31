package com.brand_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brand_service.dto.APIResponse;
import com.brand_service.dto.BrandDTO;
import com.brand_service.service.BrandService;
import com.brand_service.util.BrandUtil;
import com.brand_service.util.Constants;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandUtil util;

    @PostMapping(value="/add-brand", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse<BrandDTO>> addBrand(@RequestBody BrandDTO brandDto) {
        log.info("BrandController::addBrand() - Request body: {}", util.jsonAsString(brandDto));
        
        BrandDTO savedStoreDTO = brandService.saveBrand(brandDto);
        APIResponse<BrandDTO> response = APIResponse.<BrandDTO>builder()
                .status(Constants.SUCCESS)
                .build();
        
        if (savedStoreDTO != null) {
            log.info("BrandController::addBrand() - Response: {}", util.jsonAsString(response));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            log.error("BrandController::addStore() - Internal server error while saving store");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

  
    @GetMapping(value = "/brands", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BrandDTO>> getAllbrands(){
        log.info("BrandController::getAllbrands() - Execution started");
        
        List<BrandDTO> brands = brandService.getBrands();
        
        log.info("BrandController::getAllbrands() - Response: {}", util.jsonAsString(brands));
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{brandId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BrandDTO> getBrandById(@PathVariable Long brandId){
        log.info("BrandController::getBrandById() - Execution started");
        
        BrandDTO brand = brandService.getBrandById(brandId);
        
        log.info("BrandController::getBrandById() - Response: {}", util.jsonAsString(brand));
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }
    
    
    
}