package com.dealer_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealer_service.entity.Dealer;

public interface DealerDAO extends JpaRepository<Dealer, Long>{

}
