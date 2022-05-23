package com.ufrn.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.entity.Rent;
import com.ufrn.repository.RentRepository;

@Service
public class RentService {

	@Autowired
	RentRepository repositoryR;
	
	public Rent addRent(Rent rent) {
		Rent r = repositoryR.save(rent); 
		return r;
	}
	
}
