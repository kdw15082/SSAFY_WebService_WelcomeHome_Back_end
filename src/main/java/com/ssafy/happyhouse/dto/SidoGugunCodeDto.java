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
@ApiModel(value = "SidoGugunCode (시도 구군 코드 정보)", description = "시도 구군 코드 정보를 나타낸다.")
public class SidoGugunCodeDto {

	@ApiModelProperty(value = "시도 코드")
	private String sidoCode;
	@ApiModelProperty(value = "시도 이름")
	private String sidoName;
	@ApiModelProperty(value = "구군 코드")
	private String gugunCode;
	@ApiModelProperty(value = "구군 이름")
	private String gugunName;

}
