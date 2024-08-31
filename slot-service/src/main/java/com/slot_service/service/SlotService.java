package com.slot_service.service;

import java.util.List;

import com.slot_service.dto.SlotDTO;

public interface SlotService {
	SlotDTO saveSlot(SlotDTO slotDto);
	List<SlotDTO> getSlots();
	SlotDTO getSlotById(Long slotId);
	
  }
