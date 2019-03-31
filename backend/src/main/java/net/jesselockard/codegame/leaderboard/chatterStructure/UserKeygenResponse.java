package net.jesselockard.codegame.leaderboard.chatterStructure;

public class UserKeygenResponse {
	String userToken;
	
	public UserKeygenResponse(String token) {
		this.setUserToken(token);
	}
	
	public void setUserToken(String token) {
		this.userToken = token;
	}
	
	public String getUserToken() {
		return this.userToken;
	}
}
