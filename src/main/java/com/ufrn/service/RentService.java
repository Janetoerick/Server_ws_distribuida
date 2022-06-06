package com.ufrn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.Exception.EntityNotFoundException;
import com.ufrn.entity.Clothes;
import com.ufrn.entity.Rent;
import com.ufrn.repository.ClothesRepository;
import com.ufrn.repository.RentRepository;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class RentService {

	@Autowired
	RentRepository repositoryR;

	@Autowired
	ClothesRepository repositoryC;

	public Rent addRent(Rent rent) {

		Optional<Clothes> c = repositoryC.findById(rent.getClothes().getId()); // pega a loja que eh mencionada  (pelo id)

		int days = (int) ChronoUnit.DAYS.between(rent.getDate_start(), rent.getDate_finish()) + 1; // quantos dias tem de diferenca
		rent.setPrice(c.get().getPrice() * days); // calcula o preco total do aluguel a partir do preco diario mencionado da roupa

		Rent r = repositoryR.save(rent);
		return r;
	}

	public Rent findById(Long id) throws EntityNotFoundException {
		Optional<Rent> opt = repositoryR.findById(id);
		if (opt.isEmpty()) { // verificando se existe aluguel com o id mencionado
			throw new EntityNotFoundException();
		} else {
			return opt.get();
		}
	}

}
