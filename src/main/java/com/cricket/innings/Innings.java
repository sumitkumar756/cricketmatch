package com.cricket.innings;

import java.util.Arrays;
import java.util.List;

import com.cricket.entity.Over;
import com.cricket.entity.Player;
import com.cricket.entity.PlayerType;
import com.cricket.entity.Team;

public class Innings {

	public Team bowlingTeam;
	public Team battingTeam;
	
	// No Ball -3,Wicket -1,Wide ball -2
	public List<Integer> boundries = Arrays.asList(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6);
	public Player currentBowler;
	public Player bastmanOnStrike;
	public Player bastmanOnNonStrike;

	public void startInning(int overs) {

		// first inning
		System.out.println("batting team:"+battingTeam.players);
		System.out.println("bowling team:"+bowlingTeam.players);
		int firstTeamScore = playInning(overs);
         
		// Start second inning
		Team team = this.battingTeam;
		this.battingTeam = this.bowlingTeam;
		this.bowlingTeam = team;
		

		int secondTeamScore = playInning(overs);

	}

	private int playInning(int totalOvers) {

		int totalRun = 0;
		int runningOver = 1;
		while (runningOver <= totalOvers) {
			int bowls = 1;
			currentBowler = bowlingTeam.getPlayers().parallelStream()
					.filter(player -> (player.type == PlayerType.bowler || player.type == PlayerType.allrounder)
							&& !player.equals(currentBowler))
					.findAny().get();
			System.out.println("-----------------");
			System.out.println(
					String.format("%-15s", currentBowler.getName() + " Bowling" + "   " + "Over(" + runningOver + ")"));
			System.out.println("-----------------");

			while (bowls <= 6) {

				if (bastmanOnStrike == null) {
					bastmanOnStrike = battingTeam.getPlayers().parallelStream().filter(player -> !player.out)
							.filter(player -> player.type == PlayerType.bastman).findAny()
							.orElse(battingTeam.getPlayers().parallelStream()
									.filter(player -> player.type == PlayerType.allrounder).findAny()
									.orElse(battingTeam.getPlayers().parallelStream()
											.filter(player -> player.type == PlayerType.bowler).findAny().get()));
				}
				if (bastmanOnNonStrike == null) {
					bastmanOnNonStrike = battingTeam.getPlayers().parallelStream().filter(player -> !player.out)
							.filter(player -> player.type == PlayerType.bastman && player != bastmanOnStrike).findAny()
							.orElse(battingTeam.getPlayers().parallelStream()
									.filter(player -> player.type == PlayerType.allrounder && player != bastmanOnStrike)
									.findAny()
									.orElse(battingTeam.getPlayers().parallelStream().filter(
											player -> player.type == PlayerType.bowler && player != bastmanOnStrike)
											.findAny().get()));
				}

				int runOnBall = boundries.parallelStream().parallel().findAny().get();
				if (runOnBall == -2 || runOnBall == -3) {
					runOnBall++;
					System.out.println(Over.values()[bowls - 1] + " ball  1 extra run");
				} else {
					if (runOnBall == -1) {
						System.out.println(Over.values()[bowls - 1] + " ball     " + bastmanOnStrike.name + " caught");
						bastmanOnStrike.out = true;
						battingTeam.players.add(bastmanOnStrike);
						bastmanOnStrike = null;
						battingTeam.setWicketsDown(battingTeam.getWicketsDown() + 1);
					} else {
						System.out.println(Over.values()[bowls - 1] + " ball     " + bastmanOnStrike.name + " hit "
								+ runOnBall + " run");
						bastmanOnStrike.setRun(bastmanOnStrike.getRun() + runOnBall);
						if (runOnBall % 2 != 0) {
							Player player = bastmanOnNonStrike;
							bastmanOnNonStrike = bastmanOnStrike;
							bastmanOnStrike = player;
						}
					}
					bowls++;
				}

				totalRun += runOnBall;

			}
			runningOver++;
			currentBowler.setOvers(currentBowler.getOvers() + 1);

		}

		System.out.println("total score" + totalRun);
		bastmanOnStrike = null;
		bastmanOnNonStrike = null;
		return totalRun;
		
	}

}
