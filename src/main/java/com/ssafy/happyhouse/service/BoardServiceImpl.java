package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardDto> getAllBoard() {
		return boardMapper.getAllBoard();
	}

	@Override
	public List<BoardDto> searchByNickName(String nickname) {
		return boardMapper.searchByNickName(nickname);
	}

	@Override
	public List<BoardDto> searchByTitle(String title) {
		return boardMapper.searchByTitle(title);
	}

	@Override
	public List<BoardDto> searchByCategory(String category) {
		return boardMapper.searchByCategory(category);
	}

	@Override
	public BoardDto searchByNo(int bno) {
		return boardMapper.searchByNo(bno);
	}

	@Override
	public void updateHit(int bno) {
		boardMapper.updateHit(bno);
	}

	@Override
	public boolean insert(BoardDto boardDto) {
		return boardMapper.insert(boardDto) == 1;
	}

	@Override
	public boolean update(BoardDto boardDto) {
		return boardMapper.update(boardDto) == 1;
	}

	@Override
	public boolean delete(int bno) {
		return boardMapper.delete(bno) == 1;
	}

}