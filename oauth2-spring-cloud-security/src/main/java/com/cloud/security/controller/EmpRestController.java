package com.cloud.security.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.security.model.Employee;

@RestController
@EnableOAuth2Sso
public class EmpRestController extends WebSecurityConfigurerAdapter {
	@Autowired
	private OAuth2ClientContext clientContext;
	Map<Integer,Employee> empMap=new HashMap<>();
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public Collection<Employee> getEmployee()
	{
		if(ObjectUtils.isEmpty(empMap))
		{
			empMap.put(1, new Employee(1001,"anand",32,"delhi"));
			empMap.put(2, new Employee(1002,"saurav",33,"patna"));
			empMap.put(3, new Employee(1003,"kishor",34,"pune"));
			empMap.put(4, new Employee(1004,"kelvin",35,"new zeland"));
		}
		return empMap.values();
	}
	@RequestMapping(value="/employee/{empId}",method=RequestMethod.GET)
	public Collection<Employee> saveEmployee(@PathVariable Integer empId)
	{
		
			empMap.put(empId, new Employee(empId,"peter",32,"delhi"));
		
		
		return empMap.values();
	}
	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/","/employee").permitAll().anyRequest().authenticated();
	}
	@RequestMapping("/access_token")
	public String getToken()
	{
		String token=clientContext.getAccessToken().getTokenType();
		System.out.println("access_token is "+token);
		return token;
	}
	

}
