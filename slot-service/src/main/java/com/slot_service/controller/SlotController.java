package com.slot_service.controller;

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

import com.slot_service.dto.APIResponse;
import com.slot_service.dto.SlotDTO;
import com.slot_service.service.SlotService;
import com.slot_service.util.SlotUtil;
import com.slot_service.util.Constants;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/slots")
public class SlotController {

    @Autowired
    private SlotService slotService;

    @Autowired
    private SlotUtil util;

    @PostMapping(value="/add-slot", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse<SlotDTO>> addSlot(@RequestBody SlotDTO slotDto) {
        log.info("SlotController::addSlot() - Request body: {}", util.jsonAsString(slotDto));
        
        SlotDTO savedStoreDTO = slotService.saveSlot(slotDto);
        APIResponse<SlotDTO> response = APIResponse.<SlotDTO>builder()
                .status(Constants.SUCCESS)
                .build();
        
        if (savedStoreDTO != null) {
            log.info("SlotController::addSlot() - Response: {}", util.jsonAsString(response));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            log.error("SlotController::addSlot() - Internal server error while saving store");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

  
    @GetMapping(value = "/slots", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SlotDTO>> getAllSlots(){
        log.info("SlotController::getAllSlots() - Execution started");
        
        List<SlotDTO> slots = slotService.getSlots();
        
        log.info("SlotController::getAllSlots() - Response: {}", util.jsonAsString(slots));
        return new ResponseEntity<>(slots, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{slotId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SlotDTO> getSlotById(@PathVariable Long slotId){
        log.info("SlotController::getBrandById() - Execution started");
        
        SlotDTO slot = slotService.getSlotById(slotId);
        
        log.info("SlotController::getSlotById() - Response: {}", util.jsonAsString(slot));
        return new ResponseEntity<>(slot, HttpStatus.OK);
    }
    
    
    
}