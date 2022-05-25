package com.ufrn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.entity.Rent;
import com.ufrn.service.RentService;

@RestController
@RequestMapping("rent")
public class RentController {

	@Autowired
	RentService rentService;
	
	@PostMapping("add")
	public ResponseEntity<Rent> add(@RequestBody Rent rent) {
		return ResponseEntity.ok(rentService.addRent(rent));
	}
	
}
