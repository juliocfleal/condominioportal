package com.condominioportal.condominio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominioportal.condominio.entities.Logo;

@Repository
public interface LogoRepository extends JpaRepository<Logo, Long>{

}
