package com.jjx.shoot.core.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjx.shoot.core.entity.User;
import com.jjx.shoot.core.service.UserService;

@Controller
@RequestMapping("/shoot/User")
public class UserRegistController {
	
	@Resource()
	private UserService userService ;
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public String userRegist(User user) {
		int i = userService.addUser(user);
		return String.valueOf(i);
	}
	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public String findUserById(User user) {
		return userService.findByUserName(user);
	}
}
