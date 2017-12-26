package com.cricket;

import java.util.HashMap;
import java.util.List;

import com.cricket.entity.Team;

public class MatchRunner {

	public static void main(String[] args) {
	
	 LoadTeamData loadTeamData = new LoadTeamData();
	 HashMap<String,List<Team>> teams = LoadTeamData.loadTeamsData();	

	}

}
