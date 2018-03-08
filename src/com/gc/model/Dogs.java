package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // marks the class as a hibernate entity (mapped class)
@Table(name = "dogs") // maps the class to the DB table 
public class Dogs {
	private int dogID;
	private String dogName;
	private String breed;
	private String size;
	private String food;
	

	
	
	public Dogs() {
		
	}

	public Dogs(String dogName, String breed, String size, String food) {
				
		this.dogName = dogName;
		this.breed = breed;
		this.size = size;
		this.food = food;
		
	}

	@Id // maps the primary key
	@GeneratedValue //  generate a value for the field automatically
	@Column(name = "dogID") //  column names 
	public int getDogID() {
		return dogID;
	}

	public void setDogID(int dogID) {
		this.dogID = dogID;
	}

	@Column
	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	@Column
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Column
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}



}
