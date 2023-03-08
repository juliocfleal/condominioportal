package com.condominioportal.condominio.DTO;

import java.time.Instant;
import java.util.Objects;

import com.condominioportal.condominio.entities.Alert;

public class AlertDTO {

	private Long id;
	private String name;
	private String text;
	private Instant start;
	private Instant end;
	
	public AlertDTO() {
	}

	public AlertDTO(Long id, String name, String text, Instant start, Instant end) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
		this.start = start;
		this.end = end;
	}
	
	public AlertDTO(Alert alert) {
		this.id = alert.getId();
		this.name = alert.getName();
		this.text = alert.getText();
		this.start = alert.getStart();
		this.end = alert.getEnd();
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
		return end;
	}

	public void setEnd(Instant end) {
		this.end = end;
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
		AlertDTO other = (AlertDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
