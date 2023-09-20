package com.luma.security;

import java.security.Key;
import java.util.Date;
//
import com.luma.exception.EmployeeAppException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	@Value("${app.jwt.secret}")
	private String jwtSecret;
	@Value("${app.jwt.expiration-milliseconds}")
	private long expiryTime;
	
	
	public String generateToken(Authentication authentication) {
		
		String username=authentication.getName();
		
	    Date currentDate=new Date();
	    
	    Date expiryDate=new Date(currentDate.getTime()+expiryTime);
	    
	    
	    String token=Jwts.builder()
	    	.setSubject(username)
	    	.setIssuedAt(currentDate)
	    	.setExpiration(expiryDate)
	    	.signWith(key())
	    	.compact();
	    
	    return token;
	    	
	}
	
	private Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}
	
	public String getUsername(String token) {
		
		Claims claims=Jwts.parserBuilder()
			.setSigningKey(key())
			.build()
			.parseClaimsJws(token)
			.getBody();
		
		return claims.getSubject();
		
	}
	
	public boolean validateToken(String token) {
		
		try {
			Jwts.parserBuilder()
			.setSigningKey(key())
			.build()
			.parse(token);
			return true;
		}
		catch(MalformedJwtException ex) {
			throw new EmployeeAppException(HttpStatus.BAD_REQUEST,"Invalid token");
			
		}
		catch(ExpiredJwtException ex) {
			throw new EmployeeAppException(HttpStatus.BAD_REQUEST,"JWT token expired");
			
		}
		catch(UnsupportedJwtException ex) {
			throw new EmployeeAppException(HttpStatus.BAD_REQUEST,"Unsupported Token");
			
		}
		catch(IllegalArgumentException ex) {
			throw new EmployeeAppException(HttpStatus.BAD_REQUEST,"Token Claims String is Empty");
			
		}
		
	}
	
	
	
	
	

}
