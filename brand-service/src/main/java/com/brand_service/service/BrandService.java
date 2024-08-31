package com.brand_service.service;

import java.util.List;

import com.brand_service.dto.BrandDTO;

public interface BrandService {
	public BrandDTO saveBrand(BrandDTO brandDto);
	public BrandDTO getBrandById(Long brandId);
	public List<BrandDTO> getBrands();
	
  }
