package com.ufrn.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.entity.Clothes;
import com.ufrn.repository.ClothesRepository;

@Service
public class ClothesService {

	@Autowired
	ClothesRepository repository;
	
	public Clothes addClothes(Clothes clothes) {
		Clothes c = repository.save(clothes); 
		return c;
	}
	
	public ArrayList<Clothes> getInformation(String style) {
		ArrayList<Clothes> clothes = new ArrayList<>();
		// Adicionar regra de negócio 
		return clothes;
	}
}
