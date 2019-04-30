package com.mphasis.training.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mphasis.training.validations.CheckCase;
import com.mphasis.training.validations.CaseMode;;
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int carid;
	@CheckCase(CaseMode.UPPER)
	private String engine;
	private String gear;
	private String model;
	private String tyre;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getGear() {
		return gear;
	}
	public void setGear(String gear) {
		this.gear = gear;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTyre() {
		return tyre;
	}
	public void setTyre(String tyre) {
		this.tyre = tyre;
	}

}
