package com.cricket.entity;

import java.util.List;

public class Team {
	
	public String country;
	public List<Player> players;
	public int totalScore;
	public boolean matchWinner = false;
	public int wicketsDown;
	public int totalOvers;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	public int getTotalOvers() {
		return totalOvers;
	}
	public void setTotalOvers(int totalOvers) {
		this.totalOvers = totalOvers;
	}
	public int getWicketsDown() {
		return wicketsDown;
	}
	public void setWicketsDown(int wicketsDown) {
		this.wicketsDown = wicketsDown;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public int getScore() {
		return totalScore;
	}
	public void setScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public boolean isMatchWinner() {
		return matchWinner;
	}
	public void setMatchWinner(boolean matchWinner) {
		this.matchWinner = matchWinner;
	}
	
	
	

}
