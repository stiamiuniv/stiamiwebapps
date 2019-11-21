package com.stiamiwebapps.stiami.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stiamiwebapps.stiami.constants.Constant;
import com.stiamiwebapps.stiami.model.Users;
import com.stiamiwebapps.stiami.repository.UsersRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repository.findByUserName(username);
		if(user != null) {
			return new User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		}else {
			if (Constant.ADMIN_ACCOUNT_USERNAME.equals(username)) {
				return new User(Constant.ADMIN_ACCOUNT_USERNAME, Constant.ADMIN_ACCOUNT_PASSWORD,
						new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		}
	}
	
	public Users loadUserByFacebookOrGoogleId(String id) throws UsernameNotFoundException {
		Users user = repository.findByFaceBookId(id);
		if(user != null) {
			return user;
		}else {
			user = repository.findByGoogleId(id);
			if(user != null) {
				return user;
			}else {
				throw new UsernameNotFoundException("User not found ");
			}
			
		}
	}
}