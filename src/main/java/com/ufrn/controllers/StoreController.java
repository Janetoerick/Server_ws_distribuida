package com.ufrn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Store> takeClothes(@PathVariable Long id) throws EntityNotFoundException{
		
		return ResponseEntity.ok(storeService.findById(id));
	}
}
