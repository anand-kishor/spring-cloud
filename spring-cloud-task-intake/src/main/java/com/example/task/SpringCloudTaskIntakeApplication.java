package com.example.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class SpringCloudTaskIntakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskIntakeApplication.class, args);
	}

}
