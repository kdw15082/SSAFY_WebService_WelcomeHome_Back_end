package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.StatsDto;
import com.ssafy.happyhouse.mapper.StatsMapper;

@Service
public class StatsServiceImpl implements StatsService {
	
	@Autowired
	private StatsMapper statsMapper;

	@Override
	public List<StatsDto> getAllStats() {
		return statsMapper.getAllStats();
	}
	
	@Override
	public List<StatsDto> get30Daystats() {
		return statsMapper.get30Daystats();
	}

	@Override
	public List<StatsDto> getMonthStats() {
		return statsMapper.getMonthStats();
	}

	@Override
	public List<StatsDto> getWeekStats() {
		return statsMapper.getWeekStats();
	}

	@Override
	public List<StatsDto> getDayStats() {
		return statsMapper.getDayStats();
	}

	@Override
	public boolean insert() {
		return statsMapper.insert() == 1;
	}

	@Override
	public StatsDto searchByDate() {
		return statsMapper.searchByDate();
	}

	@Override
	public void updateCnt(String page) {
		statsMapper.updateCnt(page);
	}


}
