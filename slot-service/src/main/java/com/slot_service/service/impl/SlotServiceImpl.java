package com.slot_service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slot_service.dao.SlotDAO;
import com.slot_service.dto.SlotDTO;
import com.slot_service.entity.Slot;
import com.slot_service.service.SlotService;
import com.slot_service.util.SlotUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SlotServiceImpl implements SlotService {

    private final SlotDAO dao;
    private final ModelMapper modelMapper;
    private final SlotUtil util;

    
    @Autowired
    public SlotServiceImpl(SlotDAO dao, SlotUtil util, ModelMapper modelMapper) {
        this.dao = dao;
        this.util = util;
        this.modelMapper = modelMapper;
    }
   
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public SlotDTO saveSlot(SlotDTO slotDto) {
        log.info("SlotServiceImpl::saveBrand execution started.");
        Slot slotDetails = util.mapDTOToEntity(modelMapper, slotDto, Slot.class);
        Slot slot = dao.save(slotDetails);
        log.debug("SlotServiceImpl::saveBrand received response from Database {}",
                util.jsonAsString(slot));
        return util.mapEntityToDTO(modelMapper, slot, SlotDTO.class);
    }
	@Override
    public List<SlotDTO> getSlots() {
        log.info("SlotServiceImpl::getSlots execution started.");

        List<Slot> slots = dao.findAll();

        List<SlotDTO> slotsList = slots.stream()
                .map(store -> util.mapEntityToDTO(modelMapper, store, SlotDTO.class))
                .collect(Collectors.toList());

        log.info("SlotServiceImpl::getSlots response {}", util.jsonAsString(slotsList));

        return slotsList;
    }


	@Override
	public SlotDTO getSlotById(Long slotId) {
	    return dao.findById(slotId)
	        .map(brand -> util.mapEntityToDTO(modelMapper, brand, SlotDTO.class))
	        .orElseThrow(() -> new IllegalArgumentException("Slot with ID " + slotId + " not found"));
	}


}
