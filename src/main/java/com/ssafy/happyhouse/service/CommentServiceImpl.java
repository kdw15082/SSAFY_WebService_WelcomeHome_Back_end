package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.CommentDto;
import com.ssafy.happyhouse.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<CommentDto> searchByBoardNo(int bno) {
		return commentMapper.searchByBoardNo(bno);
	}

	@Override
	public CommentDto searchByNo(int cno) {
		return commentMapper.searchByNo(cno);
	}

	@Override
	public boolean insert(CommentDto commentDto) {
		return commentMapper.insert(commentDto) == 1;
	}

	@Override
	public boolean update(CommentDto commentDto) {
		return commentMapper.update(commentDto) == 1;
	}

	@Override
	public boolean delete(int cno) {
		return commentMapper.delete(cno) == 1;
	}

}
