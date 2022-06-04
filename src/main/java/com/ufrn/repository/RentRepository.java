package com.ufrn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.entity.Rent;

@Transactional
@Repository
public interface RentRepository extends JpaRepository<Rent, Long>{

}
