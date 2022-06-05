package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.UserDto;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private UserService userService;
	
	public void sendMail(String email) throws Exception {
		
		ArrayList<String> toUserList = new ArrayList<>();
		
		String str = getTempPassword(userService.getUserByEmail(email)); 
		
		toUserList.add(email);
		
		int toUserSize = toUserList.size();
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		
		simpleMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));
		
		simpleMessage.setSubject("[Happy House] 임시 비밀번호 안내 메일 입니다.");
		
		simpleMessage.setText("안녕하세요. 해피하우스 입니다.\n회원님의 변경된 임시 비밀번호는 " + str + " 입니다.\n보안을 위해 로그인 후 비밀번호를 변경해주세요.");
		
		javaMailSender.send(simpleMessage);
	}
		
	public String getTempPassword(UserDto userDto) throws Exception {
		
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
		
        userDto.setPassword(str);
        
        System.out.println("userDto 변경된 비밀번호 : " + userDto.getPassword());
        
		if (userService.update(userDto)) {
			return str;
		} else {
			return "error";
		}
	}
	
}
