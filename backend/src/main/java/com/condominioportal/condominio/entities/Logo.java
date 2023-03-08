package com.condominioportal.condominio.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Logo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String path;
	
	@OneToOne	
	@JoinColumn(name = "store_id")
	private Store store;
	
	public Logo() {
		
	}

	public Logo(Long id, String way) {
		super();
		this.id = id;
		this.path = way;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logo other = (Logo) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
