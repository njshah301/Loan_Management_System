package com.luma.service.service;
import com.luma.model.dto.LoginDto;


public interface AuthService {

	String login(LoginDto loginDto);
}
