package com.ufrn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.entity.Store;
import com.ufrn.service.StoreService;

@RestController
@RequestMapping("store")
public class StoreController {

	@Autowired
	StoreService storeService;
	
	@PostMapping("add")
	public ResponseEntity<Store> cadastrar(@RequestBody Store store) {
		
		return ResponseEntity.ok(storeService.addStore(store));
	}
}
