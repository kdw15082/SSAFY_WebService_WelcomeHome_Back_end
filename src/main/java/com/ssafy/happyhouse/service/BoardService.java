package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.BoardDto;

public interface BoardService {

	public List<BoardDto> getAllBoard();

	public List<BoardDto> searchByNickName(String nickname);

	public List<BoardDto> searchByTitle(String title);

	public List<BoardDto> searchByCategory(String category);

	public BoardDto searchByNo(int bno);

	public void updateHit(int bno);

	public boolean insert(BoardDto boardDto);

	public boolean update(BoardDto boardDto);

	public boolean delete(int bno);

}
