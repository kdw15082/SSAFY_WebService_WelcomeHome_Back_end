package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.StatsDto;

@Mapper
public interface StatsMapper {

	public List<StatsDto> getAllStats();
	
	public List<StatsDto> get30Daystats();
	
	public List<StatsDto> getMonthStats();
	
	public List<StatsDto> getWeekStats();
	
	public List<StatsDto> getDayStats();

	public int insert();
	
	public StatsDto searchByDate();
	
	public void updateCnt(String page);
	
}
