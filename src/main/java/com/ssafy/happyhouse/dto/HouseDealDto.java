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
@ApiModel(value = "HouseDeal (아파트 거래 정보)", description = "아파트 거래 정보를 나타낸다.")
public class HouseDealDto {

	@ApiModelProperty(value = "아파트 코드")
	private int aptCode;
	@ApiModelProperty(value = "아파트 이름")
	private String aptName;
	@ApiModelProperty(value = "거래 유형(전세/월세/매매)")
	private String dealType;
	@ApiModelProperty(value = "면적(평수)")
	private String area;
	@ApiModelProperty(value = "거래 연도")
	private int dealYear;
	@ApiModelProperty(value = "거래 월")
	private int dealMonth;
	@ApiModelProperty(value = "거래 일")
	private int dealDay;
	@ApiModelProperty(value = "보증금")
	private String deposit;
	@ApiModelProperty(value = "월세")
	private String rent;
	@ApiModelProperty(value = "매매")
	private String deal;
	@ApiModelProperty(value = "층")
	private String floor;

}
