package com.ufrn.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.Exception.EntityNotFoundException;
import com.ufrn.Exception.NullDataException;
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
	
	public Clothes findById(Long id) throws EntityNotFoundException {
		
		Optional<Clothes> opt = repositoryC.findById(id);
		if(opt.isEmpty()) {
			throw new EntityNotFoundException();
		}else {
			return opt.get();
		}
		
		
	}
	
	public List<Clothes> findClothesForStyleAll(String style, LocalDate start, LocalDate finish) throws NullDataException {
		List<Clothes> clothes = repositoryC.findAll();

		boolean its_ok = true;
		for(Clothes c: repositoryC.findAll()) {
			if(!c.getStyle().contains(style)) {
				clothes.remove(c);
			} else {
				for(Rent r: c.getRents()) {
					if(!(r.getDate_finish().isBefore(start)
							|| r.getDate_start().isAfter(finish))) {
						clothes.remove(c);
						its_ok = false;
						break;
					}
				}
				if(its_ok) {
					int days = (int) ChronoUnit.DAYS.between(start, finish) + 1;
					float a = c.getPrice() * days;
					c.setPrice(a);
				}
				its_ok = true;
			}
		}
		if(clothes.isEmpty()) {
			throw new NullDataException();
		}
		return clothes;
	}
	
	public void deleteById(Long id) {
		repositoryC.deleteById(id);
	}
	

}
