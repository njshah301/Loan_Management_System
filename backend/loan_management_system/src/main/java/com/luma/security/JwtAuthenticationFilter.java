package com.luma.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String jwtToken=getTokenFromRequest(request);
		System.out.println("+++++++++++++++++++"+jwtToken);
		
		if(StringUtils.hasText(jwtToken) && jwtTokenProvider.validateToken(jwtToken)) {
			
			String username=jwtTokenProvider.getUsername(jwtToken);
			
		  UserDetails userDetails=userDetailsService.loadUserByUsername(username);
		  
		  UsernamePasswordAuthenticationToken authentication
		  	=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
		  
		  authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		  
		  
		  SecurityContextHolder.getContext().setAuthentication(authentication);
			
			
			
			
			
		}
		
		filterChain.doFilter(request, response);
		
		
		
		
		
		
	}
	
	private String getTokenFromRequest(HttpServletRequest request) {
		
		
		String bearerToken=request.getHeader("Authorization");
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			
			String jwtToken=bearerToken.substring(7);
			return jwtToken;
		}
		
		return null;
	}

}
