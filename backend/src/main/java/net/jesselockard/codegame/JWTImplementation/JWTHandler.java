package net.jesselockard.codegame.JWTImplementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTHandler {
	/*
	 * Create HMAC 256bit secret key used globally for all key creation
	 * and decoding.
	 */
	private Algorithm algorithmHS = Algorithm.HMAC256("SecretKey");
	private JWTVerifier verifier;
	
	public JWTHandler() {
		this.verifier = JWT.require(this.algorithmHS)
				.build();
	}
	
	/*
	 * Creates a new JWT token using the supplied username.
	 */
	public String createUserToken(String username) {
		String token = null;
		
		/*
		 * Create a token with a payload parameter of 'username'.
		 * Uses the Algorithm generated above using the application's secret key
		 * and the HMAC algorithm.
		 */
		try {
			token = JWT.create()
					.withClaim("username", username)
					.sign(this.algorithmHS);
		} catch (JWTCreationException exception) {
			/*
			 * Exceptions are made with the JWT.create method when there is an error in
			 * the configuration of the signing or the claims cannot be converted.
			 */
			exception.printStackTrace();
		}
		
		return token;
	}
	
	/*
	 * Verifies and decodes the passed token.
	 * Method will return the DecodedJWT object.
	 * You can either use the wrappers provided by this classes methods to retrieve header and payload data.
	 * Alternatively you can use the built in methods provided by the DecodedJWT class.
	 */
	public DecodedJWT verifyUserToken(String token) {
		DecodedJWT jwt = null;
		
		try {
			jwt = this.verifier.verify(token);
		} catch(JWTVerificationException exception) {
			/*
			 * Invalid signature or claim provided.
			 */
			exception.printStackTrace();
		}
		
		return jwt;
	}
}