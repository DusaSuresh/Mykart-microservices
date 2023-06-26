package com.mykart.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mykart.entity.Inventory;

@Service
public interface InventoryService {

	ResponseEntity<Inventory> saveInventory(Inventory inventory);

	ResponseEntity<Inventory> getInventory(Long inventoryId);
	
	ResponseEntity<String> updateInventory(Long inventoryId, Inventory inventory);

	ResponseEntity<String> deleteInventory(Long inventoryId);


}
