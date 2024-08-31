package com.brand_service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brand_service.dao.BrandDAO;
import com.brand_service.dto.BrandDTO;
import com.brand_service.entity.Brand;
import com.brand_service.service.BrandService;
import com.brand_service.util.BrandUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BrandServiceImpl implements BrandService {

    private final BrandDAO dao;
    private final ModelMapper modelMapper;
    private final BrandUtil util;

    
    @Autowired
    public BrandServiceImpl(BrandDAO dao, BrandUtil util, ModelMapper modelMapper) {
        this.dao = dao;
        this.util = util;
        this.modelMapper = modelMapper;
    }
   
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public BrandDTO saveBrand(BrandDTO brandDto) {
        log.info("BrandServiceImpl::saveBrand execution started.");
        Brand brandDetails = util.mapDTOToEntity(modelMapper, brandDto, Brand.class);
        Brand brand = dao.save(brandDetails);
        log.debug("BrandServiceImpl::saveBrand received response from Database {}",
                util.jsonAsString(brand));
        return util.mapEntityToDTO(modelMapper, brand, BrandDTO.class);
    }
	@Override
    public List<BrandDTO> getBrands() {
        log.info("BrandServiceImpl::getBrands execution started.");

        List<Brand> brands = dao.findAll();

        List<BrandDTO> brandsList = brands.stream()
                .map(store -> util.mapEntityToDTO(modelMapper, store, BrandDTO.class))
                .collect(Collectors.toList());

        log.info("BrandServiceImpl::getBrands response {}", util.jsonAsString(brandsList));

        return brandsList;
    }


	@Override
	public BrandDTO getBrandById(Long brandId) {
	    return dao.findById(brandId)
	        .map(brand -> util.mapEntityToDTO(modelMapper, brand, BrandDTO.class))
	        .orElseThrow(() -> new IllegalArgumentException("Brand with ID " + brandId + " not found"));
	}


}
