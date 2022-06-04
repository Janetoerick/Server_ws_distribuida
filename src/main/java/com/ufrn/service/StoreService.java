package com.ufrn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.Exception.EntityNotFoundException;
import com.ufrn.entity.Store;
import com.ufrn.repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	StoreRepository repositoryS;
	
	public Store addStore(Store store) {
		Store s = repositoryS.save(store); 
		return s;
	}
	
	public Store findById(Long id) throws EntityNotFoundException {
		
		Optional<Store> opt = repositoryS.findById(id);
		if(opt.isEmpty()) {
			throw new EntityNotFoundException();
		}else {
			return opt.get();
		}
	}
	
	public void deleteById(Long id) {
		repositoryS.deleteById(id);
	}
	
}
