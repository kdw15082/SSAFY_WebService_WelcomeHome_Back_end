package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.StatsDto;
import com.ssafy.happyhouse.dto.CommentDto;
import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.service.StatsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("StatsController V1")
@RestController
@RequestMapping("/stats")
public class StatsController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private StatsService statsService;
	
	@ApiOperation(value = "통계 전체 조회", notes = "모든 통계 정보를 반환한다.", response = List.class)
	@GetMapping("/all")
	public ResponseEntity<List<StatsDto>> getAllStats() throws Exception {
		logger.debug("getAllBoard - 호출");
		return new ResponseEntity<List<StatsDto>>(statsService.getAllStats(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "통계 30일 조회", notes = "최근 30일 통계 정보를 반환한다.", response = List.class)
	@GetMapping("/recentMonth")
	public ResponseEntity<List<StatsDto>> get30Daystats() throws Exception {
		logger.debug("getAllBoard - 호출");
		return new ResponseEntity<List<StatsDto>>(statsService.get30Daystats(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "월간 통계 조회", notes = "월간 통계 정보를 반환한다.", response = List.class)
	@GetMapping("/month")
	public ResponseEntity<List<StatsDto>> getMonthStats() throws Exception {
		logger.debug("getAllBoard - 호출");
		return new ResponseEntity<List<StatsDto>>(statsService.getMonthStats(), HttpStatus.OK);
	}
	
//	@ApiOperation(value = "주간 통계 조회", notes = "주간 통계 정보를 반환한다.", response = List.class)
//	@GetMapping("/week")
//	public ResponseEntity<List<StatsDto>> getWeekStats() throws Exception {
//		logger.debug("getAllBoard - 호출");
//		return new ResponseEntity<List<StatsDto>>(statsService.getWeekStats(), HttpStatus.OK);
//	}
	
	@ApiOperation(value = "일간 통계 조회", notes = "일간 통계 정보를 반환한다.", response = List.class)
	@GetMapping("/day")
	public ResponseEntity<List<StatsDto>> getDayStats() throws Exception {
		logger.debug("getAllBoard - 호출");
		return new ResponseEntity<List<StatsDto>>(statsService.getDayStats(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "통계 등록", notes = "새로운 통계 정보를 등록한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insert() {
		logger.debug("insertBoard - 호출");
		if (statsService.insert()) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "통계 수 증가", notes = "해당하는 칼럼의 수를 증가한 후 저장한다. ", response = String.class)
	@PutMapping("/{page}")
	public void updateCnt(@PathVariable String page) {
		logger.debug("updateCnt - 호출");
		statsService.updateCnt(page);
	}
	
	@ApiOperation(value = "당일 통계 조회", notes = "오늘 통계 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/today")
	ResponseEntity<StatsDto> searchByDate() throws Exception {
		return new ResponseEntity<StatsDto>(statsService.searchByDate(), HttpStatus.OK);
	}
	
}
