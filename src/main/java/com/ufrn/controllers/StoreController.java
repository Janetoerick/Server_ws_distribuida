package com.ufrn.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.Exception.EntityNotFoundException;
import com.ufrn.entity.Store;
import com.ufrn.service.StoreService;

@RestController
@RequestMapping("store")
public class StoreController {

	@Autowired
	StoreService storeService;
	
	@PostMapping("add")
	public ResponseEntity<Store> add(@RequestBody Store store) {
		
		return ResponseEntity.ok(storeService.addStore(store));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findStore(@PathVariable Long id) throws EntityNotFoundException{
		try {
			return ResponseEntity.ok(storeService.findById(id));
		} catch (EntityNotFoundException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Store not exist");
		}
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
	
		storeService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}
