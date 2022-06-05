package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@ApiModel(value = "UserDto : 회원정보", description = "회원의 상세 정보를 나타낸다.")
public class UserDto {

	@ApiModelProperty(value = "회원 이메일")
	private String email;
	@ApiModelProperty(value = "회원 이름")
	private String name;
	@ApiModelProperty(value = "회원 비밀번호")
	private String password;
	@ApiModelProperty(value = "회원 별명")
	private String nickname;
	@ApiModelProperty(value = "회원 나이")
	private int age;
	@ApiModelProperty(value = "회원 성별")
	private String gender;
	@ApiModelProperty(value = "회원 가입 일자")
	private String regdate;

}
