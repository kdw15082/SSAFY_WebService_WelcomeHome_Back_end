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
@ApiModel(value = "Comment (댓글 정보)", description = "댓글 정보를 나타낸다.")
public class CommentDto {
	
	@ApiModelProperty(value = "댓글번호")
	private int cno;
	@ApiModelProperty(value = "글번호")
	private int bno;
	@ApiModelProperty(value = "작성자 별명")
	private String nickname;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String date;
	
}
