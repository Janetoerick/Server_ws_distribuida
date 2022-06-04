package com.ufrn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.entity.Store;

@Transactional
@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

}
