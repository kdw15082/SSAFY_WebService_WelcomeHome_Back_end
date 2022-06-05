package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.StatsDto;

public interface StatsService {

	public List<StatsDto> getAllStats();
	
	public List<StatsDto> get30Daystats();
	
	public List<StatsDto> getMonthStats();
	
	public List<StatsDto> getWeekStats();
	
	public List<StatsDto> getDayStats();

	public boolean insert();
	
	public StatsDto searchByDate();
	
	public void updateCnt(String page);

}
