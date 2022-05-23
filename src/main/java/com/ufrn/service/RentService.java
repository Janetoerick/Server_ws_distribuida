package com.ufrn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.entity.Rent;
import com.ufrn.repository.RentRepository;

@Service
public class RentService {

	@Autowired
	RentRepository repository;
	
	public Rent addRent(Rent rent) {
		Rent r = repository.save(rent); 
		return r;
	}
	
	public Optional<List<Rent>> getRentByIdClothes(long id){
		return repository.getByIdClothes(id);
	}
}
