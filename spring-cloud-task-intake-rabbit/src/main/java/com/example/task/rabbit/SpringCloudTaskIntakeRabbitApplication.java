package com.example.task.rabbit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class SpringCloudTaskIntakeRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskIntakeRabbitApplication.class, args);
	}
	@Autowired
	private Source source;
	@RequestMapping(path="/taskLauncher",method=RequestMethod.GET)
	public String publishTask(@RequestParam("commandArgs") String commandArgs)
	{
		String uri="maven://com.cloud.task:spring-cloud-task:jar:0.0.1-SNAPSHOT";
		String args[]=commandArgs.split(",");
		List<String> commandArgsList=new ArrayList<String>();
		commandArgsList.add(args[0]);
		commandArgsList.add(args[1]);
		TaskLaunchRequest request=new TaskLaunchRequest(uri,commandArgsList,null,null,"TaskLauncher");
		source.output().send(new GenericMessage<TaskLaunchRequest> (request));
		return "success";
	}

}
