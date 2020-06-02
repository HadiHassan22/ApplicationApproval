package com.letsbot.app.application_approval;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication

public class ApprovalProcessApplication {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@EventListener
	private void processPostDeploy(PostDeployEvent event) {
		runtimeService.startProcessInstanceById("applicationApproval");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApprovalProcessApplication.class, args);
	}

}
