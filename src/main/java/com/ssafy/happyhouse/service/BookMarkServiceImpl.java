package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.BookMarkDto;
import com.ssafy.happyhouse.mapper.BookMarkMapper;

@Service
public class BookMarkServiceImpl implements BookMarkService {

	@Autowired
	private BookMarkMapper bookMarkMapper;

	@Override
	public boolean insert(BookMarkDto bookMarkDto) throws Exception {
		return bookMarkMapper.insert(bookMarkDto) == 1;
	}

	@Override
	public boolean delete(int no) throws Exception {
		return bookMarkMapper.delete(no) == 1;
	}

	@Override
	public List<BookMarkDto> getBookMarkByEmail(String email) throws Exception {
		return bookMarkMapper.getBookMarkByEmail(email);
	}

	@Override
	public int getBookMarkByCode(int aptCode) throws Exception {
		return bookMarkMapper.getBookMarkByCode(aptCode);
	}

}
