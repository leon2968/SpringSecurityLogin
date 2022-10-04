package com.zheng.loginsystem.security;

import org.springframework.stereotype.Service;

import com.zheng.loginsystem.entity.User;
import com.zheng.loginsystem.repository.UserRepository;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(usernameOrEmail);
		
		if(user!=null) {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), 
					user.getPassword(),
					user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
									.collect(Collectors.toList()));
		} else {
			throw new UsernameNotFoundException("Invalid email or password");
		}
	}

}
