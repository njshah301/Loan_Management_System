package com.luma.service.serviceImpl;

import com.luma.model.dto.LoginDto;
import com.luma.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.luma.service.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	public String login(LoginDto loginDto) {
		
		UsernamePasswordAuthenticationToken authToken=
				new UsernamePasswordAuthenticationToken(loginDto.getUsername(), 
						loginDto.getPassword());
		
		Authentication authentication=authenticationManager.authenticate(authToken);
		String token=jwtTokenProvider.generateToken(authentication);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		
		
		
		
		
		
				
		
		return token;
	}

}
