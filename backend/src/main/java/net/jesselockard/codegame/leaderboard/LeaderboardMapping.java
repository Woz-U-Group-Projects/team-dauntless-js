package net.jesselockard.codegame.leaderboard;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaderboardMapping {
	
	/*
	 * getLeaderboard provides a user's base information and progression within the game.
	 * Returns a full list of the projects they've completed, their accompanying score,
	 * their progression in other projects, and pending notifications they may have.
	 * 
	 * Ideally a call to this path should only be made once after a successful user authentication when they are shown the main page.
	 * To re-get completed projects, scores, etc. use the accompanying get methods and paths.
	 * Example: /leaderboard/completed_projects
	 * 			/leaderboard/score
	 */
	@GetMapping(path = "/leaderboard", produces = {MediaType.APPLICATION_JSON_VALUE})
	Map<String, Object> getLeaderboard(/* @RequestHeader(value = "Authorization") String JWTUserToken <- Binding for the JWT a user gains after successful authentication. */) {
		Map<String, Object> leaderboardData = new HashMap<String, Object>();
		
		leaderboardData.put("tempdata", "123");
		
		return leaderboardData;
	}
	
}