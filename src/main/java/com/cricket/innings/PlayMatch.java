package com.cricket.innings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import com.cricket.entity.Team;
import com.cricket.entity.Toss;



public class PlayMatch {
	

	public void startMatch(Set<String> teamNames, HashMap<String, Team> teams,int overs) {
		
		System.out.println(String.format("%-15s", "Tossing"));
		String tossWonTeam = teamNames.parallelStream().findAny().get();
		System.out.println(String.format("%-15s", tossWonTeam+" WON the toss"));
		Toss toss = Arrays.stream(Toss.values()).parallel().findAny().get();
		System.out.println(String.format("%-15s", tossWonTeam+" selected to "+toss.toString()+ " first"));
		Innings innings = new Innings();
		if(toss == Toss.BAT){
			innings.battingTeam = teams.get(tossWonTeam);
			innings.bowlingTeam = teams.get(teamNames.parallelStream().filter(name -> !name.equals(tossWonTeam)).findFirst().get());
		}else{
			innings.battingTeam = teams.get(teamNames.parallelStream().filter(name -> !name.equals(tossWonTeam)).findFirst().get());
			innings.bowlingTeam = teams.get(tossWonTeam);
		}
		
		
		innings.startInning(overs);
		
		
		
	}
	
	

}
