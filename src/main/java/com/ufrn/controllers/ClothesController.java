package com.ufrn.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/s={style}&ds={date_start}&df={date_finish}")
	public ResponseEntity<List<Clothes>> takeClothes(@PathVariable(value="style") String style,
			@PathVariable(value="date_start") LocalDate start, @PathVariable(value="date_finish") LocalDate finish){
		return ResponseEntity.ok(clothesService.getInformation(style, start, finish));
	}
}
