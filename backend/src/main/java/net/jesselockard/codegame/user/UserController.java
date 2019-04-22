package net.jesselockard.codegame.user;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.jesselockard.codegame.JWTImplementation.JWTHandler;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder bcryptEncoder;
	
	private JWTHandler jwt;
	
	UserController() {
		this.jwt = new JWTHandler();
	}
	
	@PostMapping(path = "/user/login", produces = {MediaType.APPLICATION_JSON_VALUE})
	Map<String, Object> loginUser(@RequestBody User user) {
		Map<String, Object> userResponse = new HashMap<String, Object>();
		
		if(user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
			userResponse.put("error", "Username or password field is empty.");
			return userResponse;
		}
		
		User searchedUser = userRepo.findByUsername(user.getUsername());
		
		if(searchedUser != null) {
			
			String encodedPass = searchedUser.getPassword();
			String basePass = user.getPassword();
			
			if(bcryptEncoder.matches(basePass, encodedPass)) {
				
				userResponse.put("username", user.getUsername());
				
				String token = this.jwt.createUserToken(user.getUsername(), encodedPass);
				
				userResponse.put("token", token);
				
				return userResponse;
				
			} else {
				userResponse.put("error", "Password does not match records.");
			}
			
		} else {
			userResponse.put("error", "No user with that username found.");
			return userResponse;
		}
		
		return userResponse;
	}
	
	@PostMapping(path = "/user/register", produces = {MediaType.APPLICATION_JSON_VALUE})
	Map<String, Object> registerUser(@RequestBody User user) {
		Map<String, Object> userResponse = new HashMap<String, Object>();
		
		if(user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
			userResponse.put("error", "Username or password field is empty.");
			return userResponse;
		}
		
		User searchedUser = userRepo.findByUsername(user.getUsername());
		
		if(searchedUser != null) {
			userResponse.put("error", "A user with this username already exist.");
			return userResponse;
		}
		
		if(user.getPassword().length() < 7) {
			userResponse.put("error", "Please ensure the password is longer than 7 characters.");
			return userResponse;
		}
		
		String password = user.getPassword();
		String encodedPass = bcryptEncoder.encode(password);
		
		user.setPassword(encodedPass);
		
		String token = this.jwt.createUserToken(user.getUsername(), user.getPassword());
		
		userResponse.put("username", user.getUsername());
		userResponse.put("token", token);
		
		userRepo.save(user);
				
		return userResponse;
	}
}
