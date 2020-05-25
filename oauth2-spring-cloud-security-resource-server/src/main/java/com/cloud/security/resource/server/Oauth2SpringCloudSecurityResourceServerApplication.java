package com.cloud.security.resource.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.security.resource.server.model.Account;

@SpringBootApplication
@EnableResourceServer
@RestController
public class Oauth2SpringCloudSecurityResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SpringCloudSecurityResourceServerApplication.class, args);
	}
	Map<Integer,Account> accMap=new HashMap<>();
	@RequestMapping("/account")
	public Collection<Account> getAccountDetails()
	{
		if(ObjectUtils.isEmpty(accMap))
		{
			accMap.put(1001,new Account(123456789,"saving","anand","icici"));
			accMap.put(1001,new Account(123456790,"current","kishor","sbi"));
			accMap.put(1001,new Account(123456791,"debit","kelvin","hdfc"));
			accMap.put(1001,new Account(123456792,"credit","peter","punb"));
		}
		return accMap.values();
	}

}
