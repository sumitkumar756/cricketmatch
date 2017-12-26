package com.cricket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

import com.cricket.entity.Team;
import com.cricket.innings.PlayMatch;

public class MatchRunner {

	public static void main(String[] args) throws IOException {

		LoadTeamData loadTeamData = new LoadTeamData();
		HashMap<String, Team> teams = loadTeamData.loadTeamsData();
		Set<String> teamNames = teams.keySet();
		for (String nammes : teamNames)
			System.out.println(nammes);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(String.format("%-15s", "Enter first team :"));
		String team1 = reader.readLine();
		while (!teamNames.contains(team1)) {
			System.out.print(String.format("team did not participate in tournament . Please enter again"));
			System.out.print(String.format("%-15s", "Enter first team :"));
			team1 = reader.readLine();
		}
		System.out.print(String.format("%-15s", "Enter second team :"));
		String team2 = reader.readLine();
		while (!teamNames.contains(team2)) {
			System.out.print(String.format("team did not participate in tournament . Please enter again"));
			System.out.print(String.format("%-15s", "Enter second team :"));
			team2 = reader.readLine();
		}
		
		MatchUtility utility = new MatchUtility();
		utility.showplayers(team1,team2,teams);
		
		System.out.print(String.format("%-15s", "Enter overs :"));
		int overs = Integer.parseInt(reader.readLine());
		
		PlayMatch playMatch = new PlayMatch();
		playMatch.startMatch(teamNames,teams,overs);
			

	}

}
