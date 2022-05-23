package com.ufrn.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.entity.Clothes;
import com.ufrn.entity.Rent;
import com.ufrn.repository.ClothesRepository;

@Service
public class ClothesService {

	@Autowired
	ClothesRepository repositoryC;
	
	public Clothes addClothes(Clothes clothes) {
		Clothes c = repositoryC.save(clothes); 
		return c;
	}
	
	public List<Clothes> getInformation(String style, LocalDate start, LocalDate finish) {
		List<Clothes> clothes = repositoryC.findAll();
		
		for(Clothes c: clothes) {
			if(c.getStyle() != style) {
				clothes.remove(c);
			} else {
				for(Rent r: c.getRents()) {
					if((r.getDate_finish().isBefore(start)
							|| r.getDate_start().isAfter(finish))) {
						clothes.remove(c);
						break;
					}
				}
			}
		}
		
		return clothes;
	}
}
