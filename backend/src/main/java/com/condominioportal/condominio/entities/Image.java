package com.condominioportal.condominio.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_image")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String path;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	public Image(Long id, String way) {
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
		Image other = (Image) obj;
		return Objects.equals(id, other.id);
	}

}
