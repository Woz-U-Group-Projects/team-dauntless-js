package net.jesselockard.codegame.leaderboard;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Leaderboard {
	@Id
	String username;
	int userScore;
	UserProject[] userProjectScore;
	
	public Leaderboard(String username, int userScore) {
		this.setUsername(username);
		this.setUserScore(userScore);
	}
	
	// ==
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	// ==
	
	public void setUserScore(int score) {
		this.userScore = score;
	}
	
	public int getUserScore() {
		return this.userScore;
	}
	
	// ==
	
	public void setUserProjectScore(UserProject[] usersProjects) {
		System.out.println(usersProjects);
		this.userProjectScore = usersProjects;
	}
	
	public UserProject[] getUserProjectScore() {
		System.out.println(this.userProjectScore);
		return this.userProjectScore;
	}
	
	// ==
}
