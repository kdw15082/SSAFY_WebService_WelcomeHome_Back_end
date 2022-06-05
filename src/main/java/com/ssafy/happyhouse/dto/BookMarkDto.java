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
@ApiModel(value = "BookMark (북마크 정보)", description = "회원의 관심 지역 정보를 나타낸다.")
public class BookMarkDto {

	@ApiModelProperty(value = "북마크 번호")
	private int no;
	@ApiModelProperty(value = "회원 이메일")
	private String email;
	@ApiModelProperty(value = "아파트 코드")
	private int aptCode;

}
