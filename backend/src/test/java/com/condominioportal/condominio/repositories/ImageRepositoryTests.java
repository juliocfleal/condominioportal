package com.condominioportal.condominio.repositories;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.condominioportal.condominio.entities.Image;
import com.condominioportal.condominio.repositories.ImageRepository;

@DataJpaTest
public class ImageRepositoryTests {

	
	@Autowired
	private ImageRepository repository;
	
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
	public void findAllImagesByStoreIdShoudReturnImagesWhenStoreIdIsValid() {
	List<Image> images = repository.findByStoreId(validStoreId);
	Assertions.assertEquals(5, images.size());
	Assertions.assertEquals(validPath, images.get(0).getPath());
	Assertions.assertEquals(validId, images.get(0).getId());
	}
	
	@Test
	public void findAllImagesByStoreShouldThrowsExceptionWhenStoreIdIsInvalid() {
		assertThatThrownBy(() -> repository.findByStoreId(invalidStoreId)).isInstanceOf(EmptyResultDataAccessException.class);
	}
	
	@Test
	public void findByIdShouldReturnImageWhenIdIsValid() {
		Optional<Image> image = repository.findById(validId);
	}
	
	@Test
	public void saveNewImageShouldSaveNewImage() {
		Image image = repository.save(new Image(null, validNewPath));
		Assertions.assertNotNull(image);
		Assertions.assertEquals(validNewPath, image.getPath());
	}
	
	@Test
	public void deleteImageShouldDeleteImageWhenIdIsValid() {
		repository.deleteById(validId);
		assertThatThrownBy(() -> repository.findByStoreId(validId)).isInstanceOf(EmptyResultDataAccessException.class);
	}
	
	@Test
	public void deleteImageShouldThrowExceptionWhenIdIsInvalid() {
		assertThatThrownBy(() -> repository.deleteById(invalidId)).isInstanceOf(EmptyResultDataAccessException.class);
	}
}
