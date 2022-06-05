package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.BoardDto;

@Mapper
public interface BoardMapper {

	public List<BoardDto> getAllBoard();

	public List<BoardDto> searchByNickName(String nickname);

	public List<BoardDto> searchByTitle(String title);

	public List<BoardDto> searchByCategory(String category);

	public BoardDto searchByNo(int bno);

	public void updateHit(int bno);

	public int insert(BoardDto boardDto);

	public int update(BoardDto boardDto);

	public int delete(int bno);

}