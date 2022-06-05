package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.UserDto;

@Mapper
public interface UserMapper {

	public int insert(UserDto userDto) throws SQLException;

	public int update(UserDto userDto) throws SQLException;

	public int delete(String email) throws SQLException;

	public UserDto login(UserDto userDto) throws SQLException;

	public UserDto getUser(String email) throws SQLException;
	
	public UserDto getUserByEmail(String email) throws SQLException;

	public UserDto getUserByNickName(String nickname) throws SQLException;

	public List<UserDto> getAllUser() throws SQLException;

	public List<UserDto> getUserByName(String name) throws SQLException;

}