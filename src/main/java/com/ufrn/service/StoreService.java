package com.ufrn.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.Exception.EntityNotFoundException;
import com.ufrn.entity.Clothes;
import com.ufrn.entity.Rent;
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
//			System.out.println("-------------------------------------------------------");
//			Set<Clothes> s = opt.get().getClothes(); 
//			for(Clothes c: s) {
//				System.out.println(c.getId());
//			}
//			
			return opt.get();
		}
	}
	
	
}
