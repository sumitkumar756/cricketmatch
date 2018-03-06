package com.cricket.innings;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.cricket.entity.Over;
import com.cricket.entity.Player;
import com.cricket.entity.PlayerType;
import com.cricket.entity.Team;

public class Innings {

	public Team bowlingTeam;
	public Team battingTeam;

	// No Ball -3,Wicket -1,Wide ball -2
	public List<Integer> boundries = Arrays.asList(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6);
	private Player currentBowler;
	private Player bastmanOnStrike;
	private Player bastmanOnNonStrike;

	public void startInning(int overs) {

		// first inning
		playInning(overs);
		System.out.println("\n"+battingTeam.getCountry()+ "innings has finished \n");
		
		
		// Start second inning
		Team team = this.battingTeam;
		this.battingTeam = this.bowlingTeam;
		this.bowlingTeam = team;

		playInning(overs);
		System.out.println("\n"+battingTeam.getCountry()+ "innings has finished \n");
		
		
		System.out.println(battingTeam.getCountry()+ " scored "+battingTeam.getTotalScore()+ " for "+battingTeam.getWicketsDown()+ " wickets in "+overs+" overs \n \n");
		
		System.out.println(bowlingTeam.getCountry()+ " scored "+bowlingTeam.getTotalScore()+ " for "+bowlingTeam.getWicketsDown()+ " wickets in "+overs+" overs");
		
		if(battingTeam.getTotalScore() > bowlingTeam.getTotalScore()){
			if(battingTeam.getWicketsDown() < bowlingTeam.getWicketsDown()){
				System.out.println(battingTeam.getCountry()+" beat "+bowlingTeam.getCountry()+ " by "+(bowlingTeam.getWicketsDown()-battingTeam.getWicketsDown())+" wickets");
			}else{
				System.out.println(battingTeam.getCountry()+" beat "+bowlingTeam.getCountry()+ " by "+(battingTeam.getTotalScore()-bowlingTeam.getTotalScore())+" run");
			}
		}else{
			if(battingTeam.getWicketsDown() > bowlingTeam.getWicketsDown()){
				System.out.println(bowlingTeam.getCountry()+" beat "+battingTeam.getCountry()+ " by "+(battingTeam.getWicketsDown()-bowlingTeam.getWicketsDown())+" wickets");
			}else{
				System.out.println(bowlingTeam.getCountry()+" beat "+battingTeam.getCountry()+ " by "+(bowlingTeam.getTotalScore()-battingTeam.getTotalScore())+" run");
			}
		}
		
	}

	private void playInning(int totalOvers) {

		int totalRun = 0;
		int runningOver = 1;
		Random random = new Random();
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

				int runOnBall = boundries.get(random.nextInt(boundries.size()));
				if (runOnBall == -2 || runOnBall == -3) {
					runOnBall++;
					System.out.println(Over.values()[bowls - 1] + " ball     1 extra run");
				} else {
					if (runOnBall == -1) {
						System.out.println(Over.values()[bowls - 1] + " ball     " + bastmanOnStrike.name + " caught");
						bastmanOnStrike.out = true;
						battingTeam.getPlayers().add(bastmanOnStrike);
						bastmanOnStrike = null;
						battingTeam.setWicketsDown(battingTeam.getWicketsDown() + 1);
					} else {
						if (runOnBall == 5)
							runOnBall = 4;
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
					if (bowls > 6) {
						if (runOnBall % 2 != 0) {
							Player newPlayer = bastmanOnNonStrike;
							bastmanOnNonStrike = bastmanOnStrike;
							bastmanOnStrike = newPlayer;
						}
					}
				}

				totalRun += runOnBall;

			}
			runningOver++;
			currentBowler.setOvers(currentBowler.getOvers() + 1);

		}

		System.out.println("total score" + totalRun);
		bastmanOnStrike = null;
		bastmanOnNonStrike = null;
		battingTeam.setTotalScore(totalRun);

	}

}
