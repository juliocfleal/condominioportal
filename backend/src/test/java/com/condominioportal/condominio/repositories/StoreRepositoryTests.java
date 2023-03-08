package com.condominioportal.condominio.repositories;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.condominioportal.condominio.entities.Image;
import com.condominioportal.condominio.entities.Store;
import com.condominioportal.condominio.entities.enums.Section;
import com.condominioportal.condominio.repositories.StoreRepository;


@DataJpaTest
public class StoreRepositoryTests {

	@Autowired
	private StoreRepository repository;
	
	private Long validId;
	private Long invalidId;
	private String validName;
	private String validPhone;
	private String validWhatsApp;
	private String validInstagram;
	private String validFacebook;
	private Section section;
	private List<Image> images;
	private Pageable pageable;
	
	@BeforeEach
	void setUp() throws Exception{
		validId = 1L;
		invalidId = 9999L;
		validName = "Banca do Queijo";
		validPhone = "3537213721";
		validWhatsApp = "35999999999";
		validInstagram = "instagram.com";
		validFacebook = "facebook.com";
		section = Section.MERCEARIA;
		images.add(new Image(null, "google.com"));
		images.add(new Image(null, "google.com"));
		Sort sort = Sort.by("name").descending();
		pageable = PageRequest.of(0, 20, sort);
	}
	
	@Test
	public void findAllPaged() {
		Page<Store> page = repository.findAll(pageable);
		Assertions.assertEquals(page.getSize(), 20);
		Assertions.assertNotNull(page);
		Assertions.assertNotNull(page.get());
	}
	
	@Test
	public void saveShouldSaveNewStore() {
		Store store = new Store(null, validName, validPhone, validWhatsApp, validInstagram, validFacebook, section);
		Store saveStore = repository.save(store);
		Assertions.assertEquals(saveStore.getName(), store.getName());
		Assertions.assertEquals(saveStore.getInstagram(), store.getInstagram());
		Assertions.assertEquals(saveStore.getFacebook(), store.getFacebook());
		Assertions.assertEquals(saveStore.getWhatsapp(), store.getWhatsapp());
		Assertions.assertEquals(saveStore.getPhone(), store.getPhone());
	}
	
	@Test
	public void findByIdShouldReturnStoreWhenIdIsValid() {
		Store store = repository.findById(validId).orElseThrow();
		Assertions.assertEquals(store.getPhone(), validPhone);
		Assertions.assertEquals(store.getWhatsapp(), validWhatsApp);
		Assertions.assertEquals(store.getInstagram(), validInstagram);
	}
	
	@Test
	public void findByIdShouldThrowsExceptionWhenIdISInvalid() {
		assertThatThrownBy(() -> repository.findById(invalidId)).isInstanceOf(EmptyResultDataAccessException.class);
	}	
	
	@Test
	public void deleteShouldDeleteWhenIdIsValid() {
		repository.deleteById(validId);
		Store store = repository.findById(validId).orElse(null);
		Assertions.assertNull(store);
		
	}
}
