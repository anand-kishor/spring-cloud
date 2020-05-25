package com.example.config.client.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbController {
	@Value("${driverClassName}")
    String driverClassName;
	@Value("${url}")
	 String url;
	@Value("${username}")
	 String username;
	@Value("${password}")
	 String password;
	@RequestMapping(value="/db",method=RequestMethod.GET)
	public String getDetails()
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("driverClassName",driverClassName);
		map.put("url",url);
		map.put("username",username);
		map.put("password",password);
		return map.toString();
	}

}
