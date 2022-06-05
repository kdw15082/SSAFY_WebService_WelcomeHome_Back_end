package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunCodeDto;

@Mapper
public interface HouseInfoMapper {

	public List<SidoGugunCodeDto> getSido() throws SQLException;

	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;

	public List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;

	public List<HouseInfoDto> getAllApt() throws SQLException;

	public List<HouseInfoDto> getAptInDong(String dong) throws SQLException;

	public List<HouseInfoDto> getAptByName(String aptName) throws SQLException;

	public List<HouseInfoDto> getAptByType(String type) throws SQLException;
	
	public HouseInfoDto getAptByAptCode(int aptCode) throws SQLException;

}
