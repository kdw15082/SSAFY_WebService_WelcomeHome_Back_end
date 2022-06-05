package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.CommentDto;
import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.service.HouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("HouseController V1")
@RestController
@RequestMapping("/map")
public class HouseController {

	private final Logger logger = LoggerFactory.getLogger(HouseController.class);

	@Autowired
	private HouseService houseService;

	@ApiOperation(value = "시도 정보", notes = "전국 시도 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
		return new ResponseEntity<List<SidoGugunCodeDto>>(houseService.getSido(), HttpStatus.OK);
	}

	@ApiOperation(value = "구군 정보", notes = "시도에 해당하는 구군 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception {
		return new ResponseEntity<List<SidoGugunCodeDto>>(houseService.getGugunInSido(sido), HttpStatus.OK);
	}

	@ApiOperation(value = "동 정보", notes = "구군에 해당하는 동 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseService.getDongInGugun(gugun), HttpStatus.OK);
	}

	@ApiOperation(value = "아파트 목록", notes = "아파트 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> apt() throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseService.getAllApt(), HttpStatus.OK);
	}

	@ApiOperation(value = "아파트 목록 - 동", notes = "동에 해당하는 아파트 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/aptDong")
	public ResponseEntity<List<HouseInfoDto>> aptDong(@RequestParam("dong") String dong) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseService.getAptInDong(dong), HttpStatus.OK);
	}

	@ApiOperation(value = "아파트 목록 - 이름", notes = "이름에 해당하는 아파트 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/aptName")
	public ResponseEntity<List<HouseInfoDto>> aptName(@RequestParam("aptName") String aptName) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseService.getAptByName(aptName), HttpStatus.OK);
	}

	@ApiOperation(value = "아파트 목록 - 타입", notes = "타입에 해당하는 아파트 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/aptType")
	public ResponseEntity<List<HouseInfoDto>> aptType(@RequestParam("type") String type) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseService.getAptByType(type), HttpStatus.OK);
	}
	
	@ApiOperation(value = "아파트 조회 - 코드", notes = "타입에 해당하는 아파트 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/aptCode")
	public ResponseEntity<HouseInfoDto> aptType(@RequestParam("aptCode") int aptCode) throws Exception {
		return new ResponseEntity<HouseInfoDto>(houseService.getAptByAptCode(aptCode), HttpStatus.OK);
	}

	@ApiOperation(value = "아파트 거래 목록", notes = "아파트코드에 해당하는 아파트 거래 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/deal")
	public ResponseEntity<List<HouseDealDto>> deal(@RequestParam("aptCode") int aptCode) throws Exception {
		return new ResponseEntity<List<HouseDealDto>>(houseService.getAptByCode(aptCode), HttpStatus.OK);
	}

	@ApiOperation(value = "아파트 거래 목록 - 거래 유형", notes = "거래 유형에 해당하는 아파트 거래 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/dealType")
	public ResponseEntity<List<HouseDealDto>> dealType(@RequestParam("aptCode") int aptCode,
			@RequestParam("dealType") String dealType) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("aptCode", aptCode);
		map.put("dealType", dealType);
		return new ResponseEntity<List<HouseDealDto>>(houseService.getAptByDealType(aptCode, dealType), HttpStatus.OK);
	}

}
