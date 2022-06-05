package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseDealDto;

@Mapper
public interface HouseDealMapper {

	public List<HouseDealDto> getAptByCode(int aptCode) throws SQLException;

	public List<HouseDealDto> getAptByDealType(int aptCode, String dealType) throws SQLException;

}
