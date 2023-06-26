package com.mykart.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.mykart.entity.Inventory;
import com.mykart.repository.InventoryRepository;
import com.mykart.service.InventoryService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component("inventoryImpl")
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public ResponseEntity<Inventory> saveInventory(Inventory inventory) {
		log.info("Inside saveinventory method of inventory service implementation");
		return new ResponseEntity<>(inventoryRepository.save(inventory), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Inventory> getInventory(Long inventoryId) {
		log.info("Inside getinventory method of inventory service implementation");
		Optional<Inventory> inventoryOptional = inventoryRepository.findById(inventoryId);
		if(inventoryOptional.isPresent()) {
			return new ResponseEntity<>(inventoryOptional.get(), HttpStatus.ACCEPTED);
		}else {
			return null;
		}
	} 
	
	public ResponseEntity<String> updateInventory(Long inventoryId, @Valid Inventory updatedInventory) {
		// Retrieve the inventoryId from the repository
        Optional<Inventory> optionalInventory = inventoryRepository.findById(inventoryId);

        // Check if the inventory exists
        if (optionalInventory.isPresent()) {
            Inventory existingInventory = optionalInventory.get();

            // Update the inventory
            existingInventory.setName(updatedInventory.getName());
            existingInventory.setDescription(updatedInventory.getDescription());

            // Save the updated inventory using the repository
            inventoryRepository.save(existingInventory);

            // Return success response
            return ResponseEntity.ok("Inventory updated successfully");
        } else {
            // Return a not found response
            return ResponseEntity.notFound().build();
        }

	}
	
	@Override
	public ResponseEntity<String> deleteInventory(Long inventoryId) {
		log.info("Inside deleteInventory method of Inventory service implementation");
		inventoryRepository.deleteById(inventoryId);
		return new ResponseEntity<>("Successfully deleted", HttpStatus.ACCEPTED);
	}

	
	

}
