package com.gdu.app13.batch;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.app13.service.UserService;
@EnableScheduling
@Component
public class SleepUserScheduler {

	@Autowired
	private UserService userService;
	
	// 매일 새벽 1시 @Scheduled(cron = "0 0 1 * * *" )
	@Scheduled(cron= "0 1 0 * * *")
	public void execute() {
		userService.sleepUserHandle();
	}
	
	
}
