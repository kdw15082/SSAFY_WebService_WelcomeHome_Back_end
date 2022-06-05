package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.BookMarkDto;

public interface BookMarkService {

	public boolean insert(BookMarkDto bookMarkDto) throws Exception;

	public boolean delete(int no) throws Exception;

	public List<BookMarkDto> getBookMarkByEmail(String email) throws Exception;

	public int getBookMarkByCode(int aptCode) throws Exception;

}
