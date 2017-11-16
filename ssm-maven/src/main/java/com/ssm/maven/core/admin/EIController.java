package com.ssm.maven.core.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Administrator
 * 这个类的目的就是映射到前端界面
 * 
 */
@Controller
@RequestMapping("/studyEI")
public class EIController {
	
	@RequestMapping("/1")
	public String studyEI1(String str) {
		String url = "redirect:/study/studyEasyUI"+str+".jsp";
		return url;
	}
}
