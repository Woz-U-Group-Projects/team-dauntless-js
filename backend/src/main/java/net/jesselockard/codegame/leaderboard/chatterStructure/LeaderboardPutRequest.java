package net.jesselockard.codegame.leaderboard.chatterStructure;

import net.jesselockard.codegame.leaderboard.UserProject;

public class LeaderboardPutRequest {
	int userScore;
	UserProject[] userProjects;
	
	public void setUserScore(int score) {
		this.userScore = score;
	}
	
	public int getUserScore() {
		return this.userScore;
	}
	
	// ===
	
	public void setUserProjects(UserProject[] userProjects) {
		this.userProjects = userProjects;
	}
	
	public UserProject[] getUserProjects() {
		return this.userProjects;
	}
}
