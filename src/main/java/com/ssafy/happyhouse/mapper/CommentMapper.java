package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.CommentDto;

@Mapper
public interface CommentMapper {

	public List<CommentDto> searchByBoardNo(int bno);

	public CommentDto searchByNo(int cno);

	public int insert(CommentDto commentDto);

	public int update(CommentDto commentDto);

	public int delete(int cno);

}
