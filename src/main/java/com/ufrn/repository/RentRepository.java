package com.ufrn.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.entity.Rent;

@Transactional
@Repository
public interface RentRepository extends JpaRepository<Rent, Long>{

}
