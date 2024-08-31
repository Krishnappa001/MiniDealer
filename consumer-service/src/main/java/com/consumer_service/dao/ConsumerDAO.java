package com.consumer_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consumer_service.entity.Consumer;

public interface ConsumerDAO extends JpaRepository<Consumer, Long>{

}
