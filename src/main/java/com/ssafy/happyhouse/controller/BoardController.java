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

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("BoardController V1")
@RestController
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	@ApiOperation(value = "게시판 글목록", notes = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<BoardDto>> getAllBoard() throws Exception {
		logger.debug("getAllBoard - 호출");
		return new ResponseEntity<List<BoardDto>>(boardService.getAllBoard(), HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글보기", notes = "게시글 번호에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/{bno}")
	public ResponseEntity<BoardDto> searchByNo(@PathVariable int bno) {
		logger.debug("detailBoard - 호출");
		return new ResponseEntity<BoardDto>(boardService.searchByNo(bno), HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글목록 - 작성자", notes = "작성자 별명에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/nickname/{nickname}")
	public ResponseEntity<List<BoardDto>> searchByNickName(@PathVariable String nickname) {
		logger.debug("searchByNickName - 호출");
		return new ResponseEntity<List<BoardDto>>(boardService.searchByNickName(nickname), HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글목록 - 제목", notes = "제목에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/title/{title}")
	public ResponseEntity<List<BoardDto>> searchByTitle(@PathVariable String title) {
		logger.debug("searchByTitle - 호출");
		return new ResponseEntity<List<BoardDto>>(boardService.searchByTitle(title), HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글목록 - 카테고리", notes = "카테고리에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/category/{category}")
	public ResponseEntity<List<BoardDto>> searchByCategory(@PathVariable String category) {
		logger.debug("searchByCategory - 호출");
		return new ResponseEntity<List<BoardDto>>(boardService.searchByCategory(category), HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글등록", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody BoardDto boardDto) {
		logger.debug("insertBoard - 호출");
		if (boardService.insert(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "게시판 글정보 수정", notes = "글번호에 해당하는 게시글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{bno}")
	public ResponseEntity<String> update(@RequestBody BoardDto boardDto) {
		logger.debug("updateBoard - 호출");

		if (boardService.update(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "게시판 조회수 증가", notes = "글번호에 해당하는 게시글의 조회수를 수정한다. ", response = String.class)
	@PutMapping("/hit/{bno}")
	public void updateHit(@PathVariable int bno) {
		logger.debug("updateHit - 호출");
		boardService.updateHit(bno);
	}

	@ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{bno}")
	public ResponseEntity<String> delete(@PathVariable int bno) {
		logger.debug("deleteBoard - 호출");
		if (boardService.delete(bno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}