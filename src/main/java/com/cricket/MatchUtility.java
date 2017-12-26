package com.cricket;

import java.util.HashMap;

import com.cricket.entity.Player;
import com.cricket.entity.Team;

public class MatchUtility {

	public void showplayers(String team1, String team2, HashMap<String, Team> teams) {
		System.out.println(team1+"'s Players");
		System.out.println("-----------------");
		Team team = teams.get(team1);
		for(Player p:team.getPlayers()){
			System.out.println(p.getName());
		}
		System.out.println();
		team = teams.get(team2);
		System.out.println(team2+"'s Players");
		System.out.println("-----------------");
		for(Player p:team.getPlayers()){
			System.out.println(p.getName());
		}
		
	}
	
	

}
