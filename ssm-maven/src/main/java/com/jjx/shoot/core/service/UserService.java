package com.jjx.shoot.core.service;


import com.jjx.shoot.core.entity.User;


public interface UserService {
	public int addUser(User user);
	
	public String findByUserName(User user);
}
