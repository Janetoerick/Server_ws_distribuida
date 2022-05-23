package com.ufrn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.entity.Clothes;

@Transactional
@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long>{

}
