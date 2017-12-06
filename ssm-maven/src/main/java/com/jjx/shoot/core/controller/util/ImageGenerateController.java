package com.jjx.shoot.core.controller.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.jjx.shoot.util.CreateFourNumber;
   
  
/** 
 * 负责生成图片的控制器 
 * 
 */  
@Controller  
@RequestMapping(value="/util")  
public class ImageGenerateController {  
      
    /* 验证码管理 */  
      
    //刷新(向服务器请求)生成验证码  
    @RequestMapping(value="/getLoginImageCode")  
    @ResponseBody  
    public String getLoginImageCode(HttpServletRequest request, HttpServletResponse response) {  
          
        response.setContentType("image/jpeg");//设置响应类型，告知浏览器输出的是图片  
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容  
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击  
        response.setDateHeader("Expire", 0);  
        CreateFourNumber cfn = new CreateFourNumber();  
        try {  
        	cfn.getRandomCode(request, response, "imageCode");//生成图片并通过response输出  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";  
    }  
  
    /** 
     * 验证码  验证 
     * @param request 
     * @param response 
     * @return 
     */  
    @RequestMapping(value="/checkImgCode")  
    @ResponseBody  
    public String checkImgCode(HttpServletRequest request, HttpServletResponse response) {  
          
        //1：获取用户输入的验证码(字符串)  
        String inputValidateCode = request.getParameter("validateCode");  
        //2：获取用户session中存储的本次生成的验证码信息(字符串)  
        String sessionId = request.getSession().getId();  
        String validateCode = (String) request.getSession().getAttribute(sessionId+"imageCode");  
        //3：判断验证码是否输入的正确  
        if(!StringUtils.isEmpty(inputValidateCode)&&inputValidateCode.equals(validateCode)) {
        	return "true";
        };
        return "false";
    }  
      
}
