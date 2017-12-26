package com.cricket.entity;

public class Player {
	
	public String country;
	public String name;
	public PlayerType type;
	public int run;
	public int wickets;
	public int catches;
	public int overs;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getOvers() {
		return overs;
	}
	public void setOvers(int overs) {
		this.overs = overs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PlayerType getType() {
		return type;
	}
	public void setType(PlayerType type) {
		this.type = type;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getCatches() {
		return catches;
	}
	public void setCatches(int catches) {
		this.catches = catches;
	}

}
