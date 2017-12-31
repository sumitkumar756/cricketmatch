package com.cricket.entity;

import java.util.Set;

public class Team {
	
	private String country;
	private Set<Player> players;
	private int score;
	private int wicketsDown;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getTotalScore() {
		return score;
	}
	public void setTotalScore(int score) {
		this.score = score;
	}
	
	public int getWicketsDown() {
		return wicketsDown;
	}
	public void setWicketsDown(int wicketsDown) {
		this.wicketsDown = wicketsDown;
	}
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	

}
