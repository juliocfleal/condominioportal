package com.condominioportal.condominio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominioportal.condominio.entities.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

}
