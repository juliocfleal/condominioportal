package com.condominioportal.condominio.repositories;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.condominioportal.condominio.entities.Logo;
import com.condominioportal.condominio.repositories.LogoRepository;

@DataJpaTest
public class logoRepositoryTests {
	
	@Autowired
	private LogoRepository repository;
	
	private Long validId;
	private Long invalidId;
	private String validPath;
	private String validNewPath;
	private Long validStoreId;
	private Long invalidStoreId;

	@BeforeEach
	void setUp() throws Exception{
		validId = 1L;
		invalidId = 9999L;
		validPath = "";
		validNewPath = "";
		validStoreId = 1L;
		invalidStoreId = 9999L;
	}
	
	@Test
	public void findLogoByStoreIdShouldReturnLogoWhenStoreIdIsValid() {
		Optional<Logo> logo = repository.findLogoByStoreId(validStoreId);
		Assertions.assertEquals(validId, logo.get().getId());
		Assertions.assertEquals(validPath, logo.get().getPath());
	}
	
	@Test
	public void findLogoByIdShouldThrowExceptionWhenStoreIdIsInvalid() {
		assertThatThrownBy(() -> repository.findLogoByStoreId(invalidStoreId)).isInstanceOf(EmptyResultDataAccessException.class);
	}
	
	@Test
	public void saveNewLogoShouldSaveNewLogo() {
		Logo logo = repository.save(new Logo(null, validNewPath));
		Assertions.assertNotNull(logo);
		Assertions.assertEquals(validNewPath, logo.getPath());
	}
	
	@Test
	public void deleteLogoByIdShouldDeleteLogoWhenIdIsValid() {
		repository.deleteById(validId);
		assertThatThrownBy(() -> repository.deleteById(validId)).isInstanceOf(EmptyResultDataAccessException.class);
	}

	@Test
	public void deleteLogoByIdShouldThrowExceptionWhenIdIsInvalid() {
		assertThatThrownBy(() -> repository.deleteById(invalidId)).isInstanceOf(EmptyResultDataAccessException.class);
	}
}
