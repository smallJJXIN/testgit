package com.jjx.shoot.core.dao;


import org.springframework.stereotype.Repository;

import com.jjx.shoot.core.entity.User;

@Repository
public interface UserDao {
	
	/**
	 * 注册添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	/**
	 * 根据email，电话号码，名字找信息
	 */
	public User findByUserInfo(User user);
	
	/**
	 * 颁发令牌 访问user以外的数据都要验证令牌
	 */
	public int setToken(User user);

}
