package com.issamdrmas.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javassist.expr.NewArray;

@Component
public class JwtTokenUtil implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static final String CLAM_KEY_USERNAME = "sub";
	static final String CLAM_KEY_AUDIENCE = "audience";
	static final String CLAM_KEY_CREATED = "created";
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;

	public String getUsernameFormToken(String token) {
		String username = null;
		
		try {
			final Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			return username = null;
		}
		return username;
				
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims = null;
		try {
	claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}
	public boolean validateToken(String authToke, UserDetails userDetails) {
		JwtUser user = (JwtUser) userDetails;
		final String username = getUsernameFormToken(authToke);
		return (username.equals(user.getUsername()) && !isTokenExpiredToken(authToke));
	}

	private boolean isTokenExpiredToken(String token) {
		final Date expiration = getExpirationDateFromTaken(token);
		return expiration.before(new Date());
	}

	private Date getExpirationDateFromTaken(String token) {
		Date expiration = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims!=null) {
				expiration = claims.getExpiration();
			}else {
				expiration = null;
			}
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	public String generateToken(JwtUser uuserDetailsJwtUser) {
		Map<String, Object> claimsMap = new HashMap<String, Object>();
		claimsMap.put(CLAM_KEY_USERNAME, uuserDetailsJwtUser.getUsername());
		claimsMap.put(CLAM_KEY_CREATED, new Date());	
		
		return generateClaims(claimsMap);
	}

	private String generateClaims(Map<String, Object> claimsMap) {
		return Jwts.builder().setClaims(claimsMap).setExpiration(generateExpiration())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Date generateExpiration() {
		return new Date(System.currentTimeMillis()+ expiration * 1000);
	}

}
