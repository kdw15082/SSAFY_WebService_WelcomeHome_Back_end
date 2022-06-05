package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean insert(UserDto userDto) throws Exception {
		return userMapper.insert(userDto) == 1;
	}

	@Override
	public boolean update(UserDto userDto) throws Exception {
		return userMapper.update(userDto) == 1;
	}

	@Override
	public boolean delete(String email) throws Exception {
		return userMapper.delete(email) == 1;
	}

	@Override
	public UserDto login(UserDto userDto) throws Exception {
		if (userDto.getEmail() == null || userDto.getPassword() == null)
			return null;
		return userMapper.login(userDto);
	}

	@Override
	public UserDto getUser(String email) throws Exception {
		return userMapper.getUser(email);
	}
	
	@Override
	public UserDto getUserByEmail(String email) throws Exception {
		return userMapper.getUserByEmail(email);
	}
	
	@Override
	public UserDto getUserByNickName(String nickname) throws Exception {
		return userMapper.getUserByNickName(nickname);
	}

	@Override
	public List<UserDto> getAllUser() throws Exception {
		return userMapper.getAllUser();
	}

	@Override
	public List<UserDto> getUserByName(String name) throws Exception {
		return userMapper.getUserByName(name);
	}

}
