package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserService {

	public boolean insert(UserDto user) throws Exception;

	public boolean update(UserDto user) throws Exception;

	public boolean delete(String email) throws Exception;

	public UserDto login(UserDto user) throws Exception;

	public UserDto getUser(String email) throws Exception;

	public UserDto getUserByEmail(String email) throws Exception;

	public UserDto getUserByNickName(String nickname) throws Exception;

	public List<UserDto> getAllUser() throws Exception;

	public List<UserDto> getUserByName(String name) throws Exception;

}
