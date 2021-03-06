package com.ssafy.happyhouse.config;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.happyhouse.dto.StatsDto;
import com.ssafy.happyhouse.service.StatsService;

@Configuration
public class HttpSessionConfig {
	
	@Autowired
	private StatsService statsService;
	
	@Bean // bean for http session listener
	public HttpSessionListener httpSessionListener() {
		return new HttpSessionListener() {
			@Override
			public void sessionCreated(HttpSessionEvent se) { // This method will be called when session created
				StatsDto statsDto = statsService.searchByDate();
				
				if(statsDto == null) {
					statsService.insert();
					statsService.updateCnt("access");
				} else {
					statsService.updateCnt("access");
				}
				System.out.println("Session Created with session id+" + se.getSession().getId());
			}

			@Override
			public void sessionDestroyed(HttpSessionEvent se) { // This method will be automatically called when session
				System.out.println("Session Destroyed, Session id:" + se.getSession().getId());
			}
		};
	}

	@Bean // bean for http session attribute listener
	public HttpSessionAttributeListener httpSessionAttributeListener() {
		return new HttpSessionAttributeListener() {
			@Override
			public void attributeAdded(HttpSessionBindingEvent se) { // This method will be automatically called when
																		// session attribute added
				System.out.println("Attribute Added following information");
				System.out.println("Attribute Name:" + se.getName());
				System.out.println("Attribute Value:" + se.getName());
			}

			@Override
			public void attributeRemoved(HttpSessionBindingEvent se) { // This method will be automatically called when
																		// session attribute removed
				System.out.println("attributeRemoved");
			}

			@Override
			public void attributeReplaced(HttpSessionBindingEvent se) { // This method will be automatically called when
																		// session attribute replace
				System.out.println("Attribute Replaced following information");
				System.out.println("Attribute Name:" + se.getName());
				System.out.println("Attribute Old Value:" + se.getValue());
			}
		};
	}
}
