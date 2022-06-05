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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.BookMarkDto;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.BookMarkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("BookMarkController V1")
@RestController
@RequestMapping("/bookmark")
public class BookMarkController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BookMarkService bookMarkService;

	@ApiOperation(value = "북마크 등록", notes = "새로운 북마크 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertBookMark(@RequestBody BookMarkDto bookMarkDto) throws Exception {
		logger.debug("insertBookMark - 호출");
		if (bookMarkService.insert(bookMarkDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "북마크 삭제", notes = "북마크 번호에 해당하는 북마크 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{no}")
	public ResponseEntity<String> deleteBoard(@PathVariable int no) throws Exception {
		logger.debug("deleteBookMark - 호출");
		if (bookMarkService.delete(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "북마크 목록 - 이메일 검색", notes = "해당하는 이메일을 가진 회원의 북마크 정보 목록을 반환한다.", response = UserDto.class)
	@GetMapping("/email/{email}")
	public ResponseEntity<List<BookMarkDto>> getBookMarkByEmail(@PathVariable String email) throws Exception {
		logger.debug("getBookMarkByEmail - 호출");
		return new ResponseEntity<List<BookMarkDto>>(bookMarkService.getBookMarkByEmail(email), HttpStatus.OK);
	}

	@ApiOperation(value = "북마크 목록 - 아파트 코드 검색", notes = "해당하는 아파트 코드를 가진 북마크 정보 목록 수를 반환한다.", response = UserDto.class)
	@GetMapping("/aptCode/{aptCode}")
	public ResponseEntity<Integer> getBookMarkByCode(@PathVariable int aptCode) throws Exception {
		logger.debug("getBookMarkByCode - 호출");
		return new ResponseEntity<Integer>(bookMarkService.getBookMarkByCode(aptCode), HttpStatus.OK);
	}

}
