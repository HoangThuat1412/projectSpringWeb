package com.projectvn;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassWord {
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
}
