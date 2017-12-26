package com.cricket.entity;

public enum PlayerType {
	
	bowler("bowler"),
	bastman("bastman"),
	allrounder("allrounder");

	private String playerType;
	PlayerType(String playerType){
		this.playerType = playerType;
	}
	
	public String getPlayerType(){
		return playerType;
	}
	
}
