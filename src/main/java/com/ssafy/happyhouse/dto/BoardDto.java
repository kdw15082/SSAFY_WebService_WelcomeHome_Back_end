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
@ApiModel(value = "Board (게시글 정보)", description = "게시글 정보를 나타낸다.")
public class BoardDto {

	@ApiModelProperty(value = "글번호")
	private int bno;
	@ApiModelProperty(value = "카테고리(말머리)")
	private String category;
	@ApiModelProperty(value = "작성자 별명")
	private String nickname;
	@ApiModelProperty(value = "제목")
	private String title;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "조회수")
	private int hit;
	@ApiModelProperty(value = "작성일")
	private String date;
	@ApiModelProperty(value = "댓글 총 갯수")
	private int count;

}