package com.condominioportal.condominio.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_alert")
public class Alert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String name;
	private String text;
	private Instant start;
	private Instant endAlert;

	public Alert() {
		
	}

	public Alert(Long id, String name, String text, Instant start, Instant end) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
		this.start = start;
		this.endAlert = end;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getStart() {
		return start;
	}

	public void setStart(Instant start) {
		this.start = start;
	}

	public Instant getEnd() {
		return endAlert;
	}

	public void setEnd(Instant end) {
		this.endAlert = end;
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
		Alert other = (Alert) obj;
		return Objects.equals(id, other.id);
	}
	
}
