package net.jesselockard.codegame.leaderboard;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import net.jesselockard.codegame.JWTImplementation.JWTHandler;
import net.jesselockard.codegame.leaderboard.chatterStructure.UserKeygenRequest;
import net.jesselockard.codegame.leaderboard.chatterStructure.UserKeygenResponse;

@RestController
public class LeaderboardMapping {
	
	@Autowired
	private LeaderboardRepository lbRepository;
	
	@PostMapping(path = "/leaderboard/generate", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	UserKeygenResponse getUserToken(@RequestBody UserKeygenRequest usersKeyRequest) {
		String username = usersKeyRequest.getUsername();
		
		JWTHandler jwt = new JWTHandler();
		String token = jwt.createUserToken(username);
		
		return new UserKeygenResponse(token);
	}
	
	/*
	 * getUserLeaderboard provides a user's (identified by the JWT passed through the header) leaderboard information
	 */
	@GetMapping(path = "/leaderboard/user", produces = {MediaType.APPLICATION_JSON_VALUE})
	Map<String, Object> getUserLeaderboard(@RequestHeader(value="Authorization") String JWTUserToken) {
		String token = JWTUserToken.replace("Bearer ", "");
		
		/*
		 * Use the JWTHandler to parse the token and ensure the user has been
		 * truly previously authenticated.
		 * 
		 * jwt.verifyUserToken will return null if the tokens signiture or claims are incorrect.
		 * The signiture should always be correct as it's defined within the JWTHandler class.
		 * The only claim provided should be within the payload as 'username' which is set to the
		 * player's username.
		 */
		JWTHandler jwt = new JWTHandler();
		DecodedJWT decodedToken = jwt.verifyUserToken(token);
		
		Map<String, Object> leaderboardResponse = new HashMap<String, Object>();

		if(decodedToken != null) {
			/*
			 * Retrieve the player's username from the payload claim 'username'
			 * of the JWT.
			 */
			Claim username = decodedToken.getClaim("username");
			String usersname = username.asString();
			
			/*
			 * Use the LeaderboardRepository to grab the user's leaderboard statistics
			 * from the MongoDB database.
			 */
			Optional<Leaderboard> usersBoard = lbRepository.findById(usersname);
			
			/*
			 * Check to see if the leaderboard existed in the database. If not one will
			 * be created for the user and returned.
			 */
			if(usersBoard.isPresent()) {
				/*
				 * Map the user's token, username, score, and leaderboard information to
				 * the leaderboardResponse hash map. 
				 */
				leaderboardResponse.put("userToken", token);
				leaderboardResponse.put("username", usersname);
				leaderboardResponse.put("userScore", usersBoard.get().getUserScore());
				leaderboardResponse.put("leaderboard", usersBoard.get().getUserProjectScore());
			}
			
			else {
				Leaderboard leaderboard = new Leaderboard(usersname, 0);
				lbRepository.save(leaderboard);
				
				leaderboardResponse.put("userToken", token);
				leaderboardResponse.put("username", usersname);
				leaderboardResponse.put("userScore", 0);
				leaderboardResponse.put("leaderboard", null);
			}
		}
		
		else {
			/*
			 * Utilize the leaderboardResponse hash map to return the token used and
			 * inform the frontend there was an error trying to authenticate the token.
			 */
			leaderboardResponse.put("userToken", token);
			leaderboardResponse.put("error", "There was an error authenticated the user's token.");
		}
		
		return leaderboardResponse;
	}
	
}