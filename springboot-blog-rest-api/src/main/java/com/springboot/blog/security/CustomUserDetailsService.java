//package com.springboot.blog.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.springboot.blog.entity.User;
//import com.springboot.blog.repository.UserRepo;
//
//public class CustomUserDetailsService implements UserDetailsService {
//	
//	@Autowired
//	private UserRepo userRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
////		User user = userRepo.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow();
//		return null;
//	}
//	
//
//}
