package com.ufrn.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.Exception.EntityNotFoundException;
import com.ufrn.Exception.NullDataException;
import com.ufrn.entity.Clothes;
import com.ufrn.entity.Rent;
import com.ufrn.entity.Store;
import com.ufrn.repository.ClothesRepository;

@Service
public class ClothesService {

	@Autowired
	ClothesRepository repositoryC;
	
	public Clothes addClothes(Clothes clothes) {
		Clothes c = repositoryC.save(clothes); 
		return c;
	}
	
	public Clothes findById(Long id) throws EntityNotFoundException {
		
		Optional<Clothes> opt = repositoryC.findById(id);
		if(opt.isEmpty()) {
			throw new EntityNotFoundException();
		}else {
			System.out.println("-------------------------------------------------");
			System.out.println(opt.get().getStore().getName());
			return opt.get();
		}
		
		
	}
	
	public List<Clothes> getClothesForStyleAll(String style, LocalDate start, LocalDate finish) throws NullDataException {
		List<Clothes> clothes = repositoryC.findAll();

		for(Clothes c: repositoryC.findAll()) {
			if(!c.getStyle().contains(style)) {
				clothes.remove(c);
			} else {
				for(Rent r: c.getRents()) {
					if(!(r.getDate_finish().isBefore(start)
							|| r.getDate_start().isAfter(finish))) {
						clothes.remove(c);
						break;
					}
				}
			}
		}
		if(clothes.isEmpty()) {
			throw new NullDataException();
		}
		return clothes;
	}
	
	

}
