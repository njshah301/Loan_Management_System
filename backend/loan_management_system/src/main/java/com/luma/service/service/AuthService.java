package org.reni.service;

import org.reni.dtos.LoginDto;


public interface AuthService {

	String login(LoginDto loginDto);
}
