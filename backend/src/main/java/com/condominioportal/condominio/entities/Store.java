package com.condominioportal.condominio.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.condominioportal.condominio.entities.enums.Section;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String name;
	private String phone;
	private String whatsapp;
	private String instagram;
	private String facebook;
	private Section section;
	

	@OneToMany
	private List<Image> images = new ArrayList<>();
	
	public Store() {

	}

	public Store(Long id, String name, String phone, String whatsapp, String instagram, String facebook,
			Section section) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.whatsapp = whatsapp;
		this.instagram = instagram;
		this.facebook = facebook;
		this.section = section;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
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
		Store other = (Store) obj;
		return Objects.equals(id, other.id);
	}

}
