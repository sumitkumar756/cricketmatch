package com.cricket.innings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import com.cricket.entity.Team;
import com.cricket.entity.Toss;



public class PlayMatch {
	
	

	public void startMatch(Set<String> teamNames, HashMap<String, Team> teams,int overs) {
		
		System.out.print(String.format("%-15s", "Tossing"));
		String tossWon = teamNames.parallelStream().findAny().get();
		Team tossWonTeam  = teams.get(tossWon);
		System.out.print(String.format("%-15s", tossWon+" WON the toss"));
		Toss toss = Arrays.stream(Toss.values()).parallel().findAny().get();
		
		
		
		
		
		
	}
	
	

}
