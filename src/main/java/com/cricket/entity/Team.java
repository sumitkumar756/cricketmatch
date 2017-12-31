package com.cricket.entity;

import java.util.Set;

public class Team {
	
	
	public Set<Player> players;
	public int totalScore;
	public boolean matchWinner = false;
	public int wicketsDown;
	
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
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
