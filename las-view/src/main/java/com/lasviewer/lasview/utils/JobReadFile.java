package com.lasviewer.lasview.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class JobReadFile {

	
	@Scheduled(fixedDelay = 1000)
	public void scheduleFixedDelayTask() {
	    System.out.println(
	      "Fixed delay task - " + System.currentTimeMillis() / 1000);
	}
	
}
