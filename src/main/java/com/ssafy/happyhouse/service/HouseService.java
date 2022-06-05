package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunCodeDto;

public interface HouseService {

	public List<SidoGugunCodeDto> getSido() throws Exception;

	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;

	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;

	public List<HouseInfoDto> getAllApt() throws Exception;

	public List<HouseInfoDto> getAptInDong(String dong) throws Exception;

	public List<HouseInfoDto> getAptByName(String aptName) throws Exception;

	public List<HouseInfoDto> getAptByType(String type) throws Exception;
	
	public HouseInfoDto getAptByAptCode(int aptCode) throws Exception;

	public List<HouseDealDto> getAptByCode(int aptCode) throws Exception;

	public List<HouseDealDto> getAptByDealType(int aptCode, String dealType) throws Exception;

}
