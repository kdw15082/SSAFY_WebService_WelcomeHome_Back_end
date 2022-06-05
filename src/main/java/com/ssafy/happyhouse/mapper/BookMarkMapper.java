package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.BookMarkDto;

@Mapper
public interface BookMarkMapper {

	public int insert(BookMarkDto bookMarkDto) throws SQLException;

	public int delete(int no) throws SQLException;

	public List<BookMarkDto> getBookMarkByEmail(String email) throws SQLException;

	public int getBookMarkByCode(int aptCode) throws SQLException;

}
