package com.issamdrmas.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.issamdrmas.model.User;

public class JwtUserFactory {

	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), user, 
				authorities(new ArrayList<String>(Arrays.asList("ROLE "+user.getRole()))), user.getEnabled());
	}

	private static Collection<? extends GrantedAuthority> authorities(ArrayList<String> arrayList) {
		return arrayList.stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
	}

}
