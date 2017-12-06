package com.jjx.shoot.core.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jjx.shoot.core.dao.UserDao;
import com.jjx.shoot.core.entity.User;
import com.jjx.shoot.core.service.UserService;
import com.jjx.shoot.util.CreateUuid;
import com.jjx.shoot.util.MdFive;
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	
	@Override
	public int addUser(User user) {
		user.setUserId(CreateUuid.getUuid());
		user.setUserType("1");
		System.out.println(user.getPassword());
		String password = MdFive.getMd5(user.getPassword());
		if(password == "error"){
			return -1;
		}
		user.setPassword(password);
		int i = userDao.addUser(user);
		return i;
	}


	@Override
	public String findByUserName(User user) {
		User user1 = userDao.findByUserInfo(user);
		if(user1.getUserId() == null) {
			return "not found";
		}
		String check = UserServiceImpl.checkPwd(user.getPassword(),user1.getPassword());
		if(check == "pass") {
			/**
			 * 简单的验证通过了 颁发令牌
			 */
			user.setUserToken(CreateUuid.getUuid());
			//设置用户指定token
			userDao.setToken(user);
			//转发到home页
			return "";
		}else {
			/**
			 * 验证没通过就error
			 */
			return "error";
		}
	}
	
	
	public static String checkPwd(String pwd ,String pwd1) {
		if(pwd == null || pwd == "") {
			return "fail";
		}
		if(pwd.equals(pwd1)) {
			return "pass";
		}
		return "fail";
	}
	
}
