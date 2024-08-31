package com.slot_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slot_service.entity.Slot;

@Repository
public interface SlotDAO extends JpaRepository<Slot, Long> {

}
