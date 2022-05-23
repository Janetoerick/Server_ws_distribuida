package com.ufrn.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.entity.Rent;

@Transactional
@Repository
public interface RentRepository extends JpaRepository<Rent, Long>{

	@Transactional
	@Query(value = "select r from rent r where r.idClothes = :idClothes")
	public  Optional<List<Rent>> getByIdClothes(long idClothes);
}
