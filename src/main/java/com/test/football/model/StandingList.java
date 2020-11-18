package com.test.football.model;

import java.io.Serializable;
import java.util.List;

public class StandingList implements Serializable{
	private List<Standing> standingList;

	public List<Standing> getStandingList() {
		return standingList;
	}

	public void setStandingList(List<Standing> standingList) {
		this.standingList = standingList;
	}

	@Override
	public String toString() {
		return "StandingList [standingList=" + standingList + ", getStandingList()=" + getStandingList()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}