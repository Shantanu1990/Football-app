package com.test.football.model;

public class Competitions {
	private String country_id;
    private String country_name;
    private String league_id;
    private String league_name;
    private String league_season;
    private String league_logo;
    private String country_logo;

	
	public String getCountry_id() {
		return country_id;
	}



	public String getCountry_name() {
		return country_name;
	}



	public String getLeague_id() {
		return league_id;
	}



	public String getLeague_name() {
		return league_name;
	}



	public String getLeague_season() {
		return league_season;
	}



	public String getLeague_logo() {
		return league_logo;
	}



	public String getCountry_logo() {
		return country_logo;
	}



	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}



	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}



	public void setLeague_id(String league_id) {
		this.league_id = league_id;
	}



	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}



	public void setLeague_season(String league_season) {
		this.league_season = league_season;
	}



	public void setLeague_logo(String league_logo) {
		this.league_logo = league_logo;
	}



	public void setCountry_logo(String country_logo) {
		this.country_logo = country_logo;
	}



	@Override
	public String toString() {
		return "Competitions [country_id=" + country_id + ", country_name=" + country_name + ", league_id=" + league_id
				+ ", league_name=" + league_name + ", league_season=" + league_season + ", league_logo=" + league_logo
				+ ", country_logo=" + country_logo + ", getCountry_id()=" + getCountry_id() + ", getCountry_name()="
				+ getCountry_name() + ", getLeague_id()=" + getLeague_id() + ", getLeague_name()=" + getLeague_name()
				+ ", getLeague_season()=" + getLeague_season() + ", getLeague_logo()=" + getLeague_logo()
				+ ", getCountry_logo()=" + getCountry_logo() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}