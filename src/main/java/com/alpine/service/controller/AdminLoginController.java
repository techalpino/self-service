package com.alpine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alpine.directory.UserAuthenticationInterface;

@Controller
public class AdminLoginController {
	@Autowired
	UserAuthenticationInterface ua;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    
    public ModelAndView  home() {
		
		boolean chkAuth = ua.ChkUserAuthentication("administrator", "2wsx@WSX", "alpine", "192.168.10.55");
		ModelAndView mav =  new ModelAndView();
		String retMessage= "";
		mav.setViewName("login");
		if(chkAuth)
			retMessage =  "Hello World!Welcome to alpine";
		else
			retMessage =  "Sorry!Authentication failed";
		
		mav.addObject("Message", retMessage);
		
		return mav;
    }
}
