package com.cloud.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskApplication.class, args);
	}
	@Bean
	public GreetingTask greetingTask()
	{
		return new GreetingTask();
	}
	public static class GreetingTask implements CommandLineRunner,TaskExecutionListener
	{

		@Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			//System.out.println("Message : "+"Hello task");
			System.out.println("Message : "+args[0]);
			
		}

		@Override
		public void onTaskStartup(TaskExecution taskExecution) {
			// TODO Auto-generated method stub
			System.out.println("task is startup");
			
		}

		@Override
		public void onTaskEnd(TaskExecution taskExecution) {
			// TODO Auto-generated method stub
			System.out.println("task is end");
			
		}

		@Override
		public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
			// TODO Auto-generated method stub
			System.out.println("task is faield");
			
		}
		
	}

}
