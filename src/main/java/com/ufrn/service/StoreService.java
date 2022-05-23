package com.ufrn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.entity.Store;
import com.ufrn.repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	StoreRepository repository;
	
	public Store addStore(Store store) {
		Store s = repository.save(store); 
		return s;
	}
	
	public Store getStore(long id) {
		return repository.getById(id);
	}
}
