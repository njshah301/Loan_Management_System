package com.luma.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeGenerator {

	public static void main(String[] args) {
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("pwd"));
		System.out.println(encoder.encode("pass"));

	}

}
