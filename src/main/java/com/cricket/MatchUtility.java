package com.cricket;

import java.util.HashMap;
import java.util.Set;

import com.cricket.entity.Player;
import com.cricket.entity.Team;

public class MatchUtility {

	public void showplayers(HashMap<String, Team> teams) {
		Set<String> teamNames = teams.keySet();
		
		for(String teamName:teamNames){
			System.out.println(teamName+"'s Players");
			System.out.println("-----------------");
			Team team = teams.get(teamName);
			for(Player p:team.getPlayers()){
				System.out.println(p.getName());
			}
			System.out.println();
		}
		
	}
	
	

}
