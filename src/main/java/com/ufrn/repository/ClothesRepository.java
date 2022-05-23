package com.ufrn.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.entity.Clothes;

@Transactional
@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long>{

//	@Transactional
//	@Query(value = "select r from clothes r where r.style = :style")
//	public ArrayList<Clothes> findByStyle(String style);

}
