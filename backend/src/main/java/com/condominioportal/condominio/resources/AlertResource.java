package com.condominioportal.condominio.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.condominioportal.condominio.DTO.AlertDTO;
import com.condominioportal.condominio.services.AlertService;

@RestController
@RequestMapping(value = "/alerts")
public class AlertResource {

	@Autowired
	private AlertService service;
	
	@GetMapping
	public ResponseEntity<Page<AlertDTO>> getAll(Pageable pageable){
		Page<AlertDTO> response = service.findAllPAge(pageable);
		return ResponseEntity.ok().body(response);	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlertDTO> findById(@PathVariable Long id){
		AlertDTO response = service.findById(id);
		return ResponseEntity.ok().body(response);		
	}
	
	@PostMapping()
	public ResponseEntity<AlertDTO> insert (@RequestBody AlertDTO dto) {
		AlertDTO response = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(response);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlertDTO> update(@PathVariable Long id, @RequestBody AlertDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
