package com.springboot.blog.security;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;

public class JwtTokenProvider {

	@Value("${app.jwt-secret}")
	private String jwtSecret;
	@Value("${app-jwt-expiration-milliseconds}")
	private long jwtExpirationDate;

	public String generateToken(Authentication authentication) {
		String userName = authentication.getName();
		LocalDate currentDate = LocalDate.now();
		Date expireDate = new Date(System.currentTimeMillis() + jwtExpirationDate);

//		Jwts.builder().setSubject(userName).issuedAt(currentDate).setExpiration(expireDate);
		return null;

	}

}
