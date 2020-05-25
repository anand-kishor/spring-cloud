package com.cloud.security.auth.batch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class Oauth2SpringCloudSecurityBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SpringCloudSecurityBatchApplication.class, args);
	}
	@Bean
	public SecurityBatch batch()
	{
		return new SecurityBatch();
	}
	class SecurityBatch implements CommandLineRunner{

		@Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			ResourceOwnerPasswordResourceDetails resource=new ResourceOwnerPasswordResourceDetails();
			resource.setAccessTokenUri("http:localhost:9091/service/oauth/token");
			resource.setClientId("peter");
			resource.setClientSecret("test");
			resource.setGrantType("password");
			resource.setPassword("pass");
			resource.setUsername("allean");
			resource.setClientAuthenticationScheme(AuthenticationScheme.header);
			OAuth2RestTemplate template=new OAuth2RestTemplate(resource);
			String results=template.getForObject("http://localhost:9090/resource/account", String.class);
			System.out.println("results: "+results);
			
		}
		
	}

}
