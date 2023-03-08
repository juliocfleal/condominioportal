package com.condominioportal.condominio.repositories;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominioportal.condominio.entities.Alert;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long>{

}
