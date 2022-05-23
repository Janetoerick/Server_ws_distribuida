package com.ufrn.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rent")
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDate date_start;
	
	private LocalDate date_finish;
	
	private long idClothes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getDate_start() {
		return date_start;
	}
	public void setDate_start(LocalDate date_start) {
		this.date_start = date_start;
	}
	public LocalDate getDate_finish() {
		return date_finish;
	}
	public void setDate_finish(LocalDate date_finish) {
		this.date_finish = date_finish;
	}
	public long getIdClothes() {
		return idClothes;
	}
	public void setIdClothes(long idClothes) {
		this.idClothes = idClothes;
	}
	
	
}
