package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.mapper.HouseDealMapper;
import com.ssafy.happyhouse.mapper.HouseInfoMapper;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseInfoMapper houseInfoMapper;

	@Autowired
	private HouseDealMapper houseDealMapper;

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return houseInfoMapper.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return houseInfoMapper.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return houseInfoMapper.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAllApt() throws Exception {
		return houseInfoMapper.getAllApt();
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		return houseInfoMapper.getAptInDong(dong);
	}

	@Override
	public List<HouseInfoDto> getAptByName(String aptName) throws Exception {
		return houseInfoMapper.getAptByName(aptName);
	}

	@Override
	public List<HouseInfoDto> getAptByType(String type) throws Exception {
		return houseInfoMapper.getAptByType(type);
	}
	
	@Override
	public HouseInfoDto getAptByAptCode(int aptCode) throws Exception {
		return houseInfoMapper.getAptByAptCode(aptCode);
	}

	@Override
	public List<HouseDealDto> getAptByCode(int aptCode) throws Exception {
		return houseDealMapper.getAptByCode(aptCode);
	}

	@Override
	public List<HouseDealDto> getAptByDealType(int aptCode, String dealType) throws Exception {
		return houseDealMapper.getAptByDealType(aptCode, dealType);
	}

}
