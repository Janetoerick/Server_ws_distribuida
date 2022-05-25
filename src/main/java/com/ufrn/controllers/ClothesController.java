package com.ufrn.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.Exception.EntityNotFoundException;
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
	
	@GetMapping("take")
	public ResponseEntity<List<Clothes>> takeClothes(@RequestParam String style,
			@RequestParam String start, @RequestParam String finish){
		LocalDate Dstart = LocalDate.parse(start);
		LocalDate Dfinish = LocalDate.parse(finish);
		
		return ResponseEntity.ok(clothesService.getInformation(style, Dstart, Dfinish));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clothes> takeClothes(@PathVariable Long id) throws EntityNotFoundException{
		
		return ResponseEntity.ok(clothesService.findById(id));
	}
}
