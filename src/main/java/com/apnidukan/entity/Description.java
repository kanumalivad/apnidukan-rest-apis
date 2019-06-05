package com.apnidukan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Description {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long  descriptionid;
	
	@Column(name="connectivity")
	String connectivity;
	
	@Column(name="sensor")
	String sensor;
	
	@Column(name="inthebox")
	String inthebox;
	
	@Column(name="battery")
	String battery;
	
	@Column(name="dimension")
	String dimension;
	
	@Column(name="color")
	String color;
	
	@Column(name="sim")
	String sim;
	
	@Column(name="display")
	String display;
	
	@Column(name="os")
	String os;
	
	@Column(name="processor")
	String processor;
	
	@Column(name="ram")
	String ram;
	
	@Column(name="frontcamera")
	String frontcamera;
	
	@Column(name="rearcamera")
	String rearcamera;
	
	@Column(name="internalmemory")
	String internalmemory;

	public long getDescriptionid() {
		return descriptionid;
	}

	public void setDescriptionid(long descriptionid) {
		this.descriptionid = descriptionid;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	public String getSensor() {
		return sensor;
	}

	public void setSensor(String sensor) {
		this.sensor = sensor;
	}

	public String getInthebox() {
		return inthebox;
	}

	public void setInthebox(String inthebox) {
		this.inthebox = inthebox;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getFrontcamera() {
		return frontcamera;
	}

	public void setFrontcamera(String frontcamera) {
		this.frontcamera = frontcamera;
	}

	public String getRearcamera() {
		return rearcamera;
	}

	public void setRearcamera(String rearcamera) {
		this.rearcamera = rearcamera;
	}

	public String getInternalmemory() {
		return internalmemory;
	}

	public void setInternalmemory(String internalmemory) {
		this.internalmemory = internalmemory;
	}
	
	
}
