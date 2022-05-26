package com.ufrn.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.Exception.EntityNotFoundException;
import com.ufrn.Exception.NullDataException;
import com.ufrn.entity.Clothes;
import com.ufrn.service.ClothesService;

@RestController
@RequestMapping("clothes")
public class ClothesController {

	@Autowired
	ClothesService clothesService;
	
	@PostMapping("add")
	public ResponseEntity<Clothes> add(@RequestBody Clothes clothes) {
		
		return ResponseEntity.ok(clothesService.addClothes(clothes));
	}
	
	@GetMapping("forStyleAll")
	public ResponseEntity<?> getClothesForStyle(@RequestParam String style,
			@RequestParam String start, @RequestParam String finish) throws NullDataException{
		LocalDate Dstart = LocalDate.parse(start);
		LocalDate Dfinish = LocalDate.parse(finish);
		
	
		if(Dstart.isAfter(Dfinish)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Date not found");
		} else {
			try {
				return ResponseEntity.ok(clothesService.getClothesForStyleAll(style, Dstart, Dfinish));
			} catch (NullDataException e) {
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("List of clothes its null");
			}
			
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clothes> takeClothes(@PathVariable Long id) throws EntityNotFoundException{
		
		return ResponseEntity.ok(clothesService.findById(id));
	}
}
