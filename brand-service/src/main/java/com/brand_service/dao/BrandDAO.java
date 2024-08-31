package com.brand_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brand_service.entity.Brand;

@Repository
public interface BrandDAO extends JpaRepository<Brand, Long> {

}
