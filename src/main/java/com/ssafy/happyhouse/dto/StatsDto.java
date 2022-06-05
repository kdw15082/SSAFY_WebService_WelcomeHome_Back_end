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
@ApiModel(value = "StatsDto : 통계정보", description = "웹페이지의 회원 통계 정보를 나타낸다.")
public class StatsDto {

	@ApiModelProperty(value = "날짜")
	private String date;
	@ApiModelProperty(value = "가입자 수")
	private int regist;
	@ApiModelProperty(value = "접속자 수")
	private int access;
	@ApiModelProperty(value = "탈퇴자 수")
	private int delete;
	@ApiModelProperty(value = "메인 페이지 방문자 수")
	private int home;
	@ApiModelProperty(value = "게시판 수")
	private int board;
	@ApiModelProperty(value = "QnA 방문자 수")
	private int qna;
	@ApiModelProperty(value = "공지사항 방문자 수")
	private int notice;
	@ApiModelProperty(value = "회원 정보 방문자 수")
	private int mypage;
	@ApiModelProperty(value = "아파트 목록 검색 방문자 수")
	private int aptlist;
	@ApiModelProperty(value = "북마크 방문자 수")
	private int bookmark;
	
}
