package com.cricket.entity;

import java.util.List;

public class Team {
	
	public List<Player> players;
	public int score;
	public boolean matchWinner  = false;
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isMatchWinner() {
		return matchWinner;
	}
	public void setMatchWinner(boolean matchWinner) {
		this.matchWinner = matchWinner;
	}
	
	
	

}
