package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.StatsDto;
import com.ssafy.happyhouse.service.StatsService;

@RestController
public class SessionController {
	
	@Autowired
	private StatsService statsService;
	
	@GetMapping("/session") // it will handle all request for /viewSessionData
	public void start(HttpServletRequest request) {

		StatsDto statsDto = statsService.searchByDate();
		
		if(statsDto == null) {
			statsService.insert();
			statsService.updateCnt("access");
		} else {
			statsService.updateCnt("access");
		}
		
	}
}
