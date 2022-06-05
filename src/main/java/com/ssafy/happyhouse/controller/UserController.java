package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.JwtServiceImpl;
import com.ssafy.happyhouse.service.MailService;
import com.ssafy.happyhouse.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("UserController V1")
@RestController
@RequestMapping("/user")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JwtServiceImpl jwtService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;

	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserDto loginUser = userService.login(userDto);
			if (loginUser != null) {
				String token = jwtService.create("email", loginUser.getEmail(), "access-token");// key, data, subject
				logger.debug("로그인 토큰정보 : {}", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{email}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("email") @ApiParam(value = "인증할 회원의 아이디.", required = true) String email,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				UserDto userDto = userService.getUser(email);
				resultMap.put("userInfo", userDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원 정보 등록 - 회원가입", notes = "새로운 회원 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertUser(@RequestBody UserDto userDto) throws Exception {
		logger.debug("registUser - 호출");
		if (userService.insert(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "회원 정보 보기", notes = "이메일에 해당하는 회원의 정보를 반환한다.", response = UserDto.class)
	@GetMapping("{email}")
	public ResponseEntity<UserDto> getUser(@PathVariable String email) throws Exception {
		logger.debug("deleteUser - 호출");
		return new ResponseEntity<UserDto>(userService.getUser(email), HttpStatus.OK);
	}

	@ApiOperation(value = "회원 정보 수정", notes = "이메일에 해당하는 회원의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{email}")
	public ResponseEntity<String> updateUser(@RequestBody UserDto userDto) throws Exception {
		logger.debug("updateUser - 호출");

		if (userService.update(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "회원 탈퇴", notes = "이메일에 해당하는 회원의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{email}")
	public ResponseEntity<String> deleteUser(@PathVariable String email) throws Exception {
		logger.debug("deleteUser - 호출");
		if (userService.delete(email)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원 정보 - 이메일 검색", notes = "해당하는 이메일을 가진 회원의 정보를 반환한다.", response = UserDto.class)
	@GetMapping("/email/{email}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) throws Exception {
		logger.debug("getUserByEmail - 호출");
		return new ResponseEntity<UserDto>(userService.getUserByEmail(email), HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원 정보 - 별명 검색", notes = "해당하는 별명을 가진 회원의 정보를 반환한다.", response = UserDto.class)
	@GetMapping("/nickname/{nickname}")
	public ResponseEntity<UserDto> getUserByNickName(@PathVariable String nickname) throws Exception {
		logger.debug("getUserByNickName - 호출");
		return new ResponseEntity<UserDto>(userService.getUserByNickName(nickname), HttpStatus.OK);
	}

	@ApiOperation(value = "회원 정보 목록 - 전체", notes = "모든 회원의 정보를 반환한다.", response = UserDto.class)
	@GetMapping()
	public ResponseEntity<List<UserDto>> getAllUser() throws Exception {
		logger.debug("getAllUser - 호출");
		return new ResponseEntity<List<UserDto>>(userService.getAllUser(), HttpStatus.OK);
	}

	@ApiOperation(value = "회원 정보 목록 - 이름 검색", notes = "해당하는 이름을 가진 회원의 정보를 반환한다.", response = UserDto.class)
	@GetMapping("/name/{name}")
	public ResponseEntity<List<UserDto>> getUserByName(@PathVariable String name) throws Exception {
		logger.debug("getUserByName - 호출");
		return new ResponseEntity<List<UserDto>>(userService.getUserByName(name), HttpStatus.OK);
	}
	
	@ApiOperation(value = "이메일 전송", notes = "임시 비밀번호를 발급하여 메일로 전송한다.", response = Map.class)
	@PostMapping("/sendMail/{email}")
	public void sendMail(@PathVariable String email) throws Exception {
		mailService.sendMail(email);
	}

}
