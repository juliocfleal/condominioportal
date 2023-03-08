package com.condominioportal.condominio.repositories;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.condominioportal.condominio.entities.Alert;
import com.condominioportal.condominio.repositories.AlertRepository;

@DataJpaTest
public class AlertRepositoryTests {

	
	@Autowired
	private AlertRepository repository;
	
	private Long validId;
	private Long invalidId;
	private String validName;
	private String validText;
	private Instant validDate;
	private Integer totalAlerts;
	private Integer alertsNotExpired;
	
	@BeforeEach
	void setUp() throws Exception{
		validId = 1L;
		invalidId = 9999L;
		validName = "Exemplo Dois";
		validText = "Exemplo de texto 2!";
		validDate = Instant.parse("2023-11-23T00:01:45.377Z");
		totalAlerts = 5;
		alertsNotExpired = 3;
	}

@Test
public void findAllShouldReturnAllAlerts() {
	List<Alert> list = repository.findAll();
	Assertions.assertEquals(totalAlerts, list.size());
	Assertions.assertEquals(validId, list.get(0).getId());
	Assertions.assertEquals(validName, list.get(1).getName());
	Assertions.assertEquals(validText, list.get(1).getText());
	Assertions.assertEquals(validDate, list.get(1).getEnd());
}

@Test
public void findAllNotExpiredShouldReturnAlerts() {
	List<Alert> list = repository.findAllNotExpired();
	Assertions.assertEquals(alertsNotExpired, list.size());
	Assertions.assertEquals(validId, list.get(0).getId());
	Assertions.assertEquals(validName, list.get(1).getName());
	Assertions.assertEquals(validText, list.get(1).getText());
	Assertions.assertEquals(validDate, list.get(1).getEnd());
}

@Test
public void findAlertByIdShouldReturnAlertWhenIdIsValid() {
	Optional<Alert> alert = repository.findById(validId);
	Assertions.assertEquals(validId, alert.get().getId());
	Assertions.assertEquals(validName, alert.get().getName());
	Assertions.assertEquals(validText, alert.get().getText());
	Assertions.assertEquals(validDate, alert.get().getEnd());
}

@Test
public void findAlertByIdShouldThrowExceptionWhenIdISInvalid() {
	assertThatThrownBy(() -> repository.findById(invalidId)).isInstanceOf(EmptyResultDataAccessException.class);
}

@Test
public void saveShouldSaveNewAlert() {
	Alert alert = new Alert(null , "Horarios de Feriado","Feriado a vir", Instant.now(),Instant.now());
	Alert alertDb = repository.save(alert);
	Assertions.assertEquals("Horarios de Feriado", alertDb.getName());
	Assertions.assertEquals("Feriado a vir", alertDb.getText());
}
}
