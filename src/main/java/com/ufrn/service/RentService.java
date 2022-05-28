package com.ufrn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.entity.Clothes;
import com.ufrn.entity.Rent;
import com.ufrn.repository.ClothesRepository;
import com.ufrn.repository.RentRepository;

import java.time.temporal.ChronoUnit;

@Service
public class RentService {

	@Autowired
	RentRepository repositoryR;
	
	public Rent addRent(Rent rent) {
		
		int days = (int) ChronoUnit.DAYS.between(rent.getDate_start(), rent.getDate_finish()) + 1;
		rent.setPrice(rent.getClothes().getPrice()*days);
		
		Rent r = repositoryR.save(rent);
		return r;
	}
	
}
