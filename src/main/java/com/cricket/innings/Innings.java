package com.cricket.innings;

import java.util.Arrays;
import java.util.List;

import com.cricket.entity.Player;
import com.cricket.entity.PlayerType;
import com.cricket.entity.Team;

public class Innings {

	public Team bowlingTeam;
	public Team battingTeam;
	//Wide ball -2
	//Wicket -1
	//No Ball -3
	public List<Integer> boundries = Arrays.asList(-3,-2,-1, 0, 1, 2, 3, 4, 5, 6);
	public Player currentBowler;
	public Player bastmanOnStrike;
	public Player bastmanOnNonStrike;

	public void startInning(int overs) {
		
		//first inning
		int firstTeamScore = playInning(overs);
		
		//Start second inning
		Team team;
		team = battingTeam;
		battingTeam = bowlingTeam;
		bowlingTeam = battingTeam;
		
		int secondTeamScore = playInning(overs);
		
		
		
	}

	private int playInning(int overs) {
		
		int totalRun = 0;
		while (overs != 0) {
			int bowls = 6;
				currentBowler = bowlingTeam.getPlayers().parallelStream()
						.filter(player -> (player.type == PlayerType.bowler || player.type == PlayerType.allrounder)
								&& !player.equals(currentBowler))
						.findAny().get();
			

			while (bowls != 0) {

				if (bastmanOnStrike == null)
					bastmanOnStrike = battingTeam.getPlayers().parallelStream()
							.filter(player -> player.type == PlayerType.bastman).findAny()
							.orElse(battingTeam.getPlayers().parallelStream()
									.filter(player -> player.type == PlayerType.allrounder).findAny()
									.orElse(battingTeam.getPlayers().parallelStream()
											.filter(player -> player.type == PlayerType.bowler).findAny().get()));
				if (bastmanOnNonStrike == null)
					bastmanOnNonStrike = battingTeam.getPlayers().parallelStream()
							.filter(player -> player.type == PlayerType.bastman && player != bastmanOnStrike).findAny()
							.orElse(battingTeam.getPlayers().parallelStream()
									.filter(player -> player.type == PlayerType.allrounder && player != bastmanOnStrike)
									.findAny()
									.orElse(battingTeam.getPlayers().parallelStream().filter(
											player -> player.type == PlayerType.bowler && player != bastmanOnStrike)
											.findAny().get()));
			
		     
				int runOnBall = boundries.parallelStream().findAny().get();
				if(runOnBall == -2 || runOnBall == -3){
					runOnBall++;
				}else{
					bowls--;
				}
				
				totalRun+=runOnBall;
				
			}
			overs--;
			currentBowler.setOvers(currentBowler.getOvers() + 1);

		}

		System.out.println("total score"+totalRun);
		return totalRun;
	}
		
	}


