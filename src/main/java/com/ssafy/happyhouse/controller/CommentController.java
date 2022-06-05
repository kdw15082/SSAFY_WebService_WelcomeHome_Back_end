package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.CommentDto;
import com.ssafy.happyhouse.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("CommentController V1")
@RestController
@RequestMapping("/comment")
public class CommentController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private CommentService commentService;

	@ApiOperation(value = "댓글 글보기", notes = "게시글 번호에 해당하는 댓글의 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/{bno}")
	public ResponseEntity<List<CommentDto>> searchByBoardNo(@PathVariable int bno) {
		logger.debug("searchByBoardNo - 호출");
		return new ResponseEntity<List<CommentDto>>(commentService.searchByBoardNo(bno), HttpStatus.OK);
	}

	@ApiOperation(value = "댓글 상세 보기", notes = "게시글 번호에 해당하는 댓글의 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/cno/{cno}")
	public ResponseEntity<CommentDto> searchByNo(@PathVariable int cno) {
		logger.debug("searchByNo - 호출");
		return new ResponseEntity<CommentDto>(commentService.searchByNo(cno), HttpStatus.OK);
	}

	@ApiOperation(value = "댓글 등록", notes = "새로운 댓글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody CommentDto commentDto) {
		logger.debug("insertComment - 호출");
		if (commentService.insert(commentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "댓글 정보 수정", notes = "댓글 번호에 해당하는 댓글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{cno}")
	public ResponseEntity<String> update(@RequestBody CommentDto commentDto) {
		logger.debug("updateComment - 호출");

		if (commentService.update(commentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "댓글 삭제", notes = "댓글번호에 해당하는 댓글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{cno}")
	public ResponseEntity<String> delete(@PathVariable int cno) {
		logger.debug("deleteComment - 호출");
		if (commentService.delete(cno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
