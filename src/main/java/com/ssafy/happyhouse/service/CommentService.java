package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.CommentDto;

public interface CommentService {

	public List<CommentDto> searchByBoardNo(int bno);

	public CommentDto searchByNo(int cno);

	public boolean insert(CommentDto commentDto);

	public boolean update(CommentDto commentDto);

	public boolean delete(int cno);

}
