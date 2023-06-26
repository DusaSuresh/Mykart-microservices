package com.mykart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mykart.entity.Inventory;
import com.mykart.service.InventoryService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/inventorys")
@Slf4j
public class InventoryController {
	
	@Autowired
	@Qualifier("inventoryImpl")
	InventoryService inventoryService;
	
	@PostMapping
	public ResponseEntity<Inventory> saveinventory(@RequestBody Inventory inventory) {
		log.info("Inside saveinventory method of inventory Controller");
		return inventoryService.saveInventory(inventory);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Inventory> getinventory(@PathVariable("id") Long inventoryId) {
		log.info("Inside getinventory method of inventory controller");
		return inventoryService.getInventory(inventoryId);
	}
	
	@PutMapping("/{inventoryId}")
	public ResponseEntity<String> updatedOrder(@PathVariable Long inventoryId, @Valid @RequestBody Inventory updatedInventory) {

		log.info("****** Request in inventoryid controller ****** Method is updatedInventory");
		return inventoryService.updateInventory(inventoryId, updatedInventory);
	}

	@DeleteMapping("/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {

		log.info("****** Request in orderId controller ****** Method is  deleteOrder");
		return inventoryService.deleteInventory(orderId);

	}


}
