package com.store_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store_service.entity.Store;

@Repository
public interface StoreDAO extends JpaRepository<Store, Long> {

}
