package com.cricket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.cricket.entity.Player;
import com.cricket.entity.PlayerType;
import com.cricket.entity.Team;

public class LoadTeamData {

	public HashMap<String,Team> loadTeamsData() throws IOException {

		HashMap<String, Team> teams = new HashMap<String,Team>();

		BufferedReader reader = new BufferedReader(new FileReader("teams.csv"));
		String line = "";
		
		Set<Player> playerList = new HashSet<Player>();
		Team team  = new Team();	
		while ((line = reader.readLine()) != null) {
			String[] teamData = line.split(",");
			Player player = new Player();
			player.setCountry(teamData[0]);
			player.setName(teamData[1]);
			
			if(team.getCountry() == null){
				team.setCountry(teamData[0]);
			}
			
			for (PlayerType pl : PlayerType.values()) {
				if (pl.getPlayerType().equals(teamData[2])) {
					player.setType(pl);
				}
			}
			if(playerList.size() == 10){
				playerList.add(player);
				team.setPlayers(playerList);
				teams.put(player.getCountry(), team);
				
				team = new Team();
				playerList = new HashSet<Player>();
			}else{
				playerList.add(player);
				
			}
		}

		return teams;
	}

}
