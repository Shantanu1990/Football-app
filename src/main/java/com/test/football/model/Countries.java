package com.test.football.model;

public class Countries {
	private String country_id;
	private String country_name;
	private String country_logo;
	
	public String getCountry_id() {
		return country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public String getCountry_logo() {
		return country_logo;
	}
	public void setCountry_logo(String country_logo) {
		this.country_logo = country_logo;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	
	@Override
	public String toString() {
		return "Countries [country_id=" + country_id + ", country_name=" + country_name + ", country_logo="
				+ country_logo + "]";
	}
}