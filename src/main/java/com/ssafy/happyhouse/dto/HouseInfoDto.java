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
@ApiModel(value = "HouseInfo (아파트 정보)", description = "아파트 정보를 나타낸다.")
public class HouseInfoDto {

	@ApiModelProperty(value = "아파트 코드")
	private int aptCode;
	@ApiModelProperty(value = "아파트 이름")
	private String aptName;
	@ApiModelProperty(value = "동 코드")
	private String dongCode;
	@ApiModelProperty(value = "동 이름")
	private String dongName;
	@ApiModelProperty(value = "시도 이름")
	private String sidoName;
	@ApiModelProperty(value = "구군 이름")
	private String gugunName;
	@ApiModelProperty(value = "건축 연도")
	private int buildYear;
	@ApiModelProperty(value = "도로명 주소")
	private String addr;
	@ApiModelProperty(value = "건물 타입(아파트/연립다세대)")
	private String type;
	@ApiModelProperty(value = "위도")
	private String lat;
	@ApiModelProperty(value = "경도")
	private String lng;
	@ApiModelProperty(value = "이미지")
	private String img;
	@ApiModelProperty(value = "최근 전세 금액")
	private String recentLease;
	@ApiModelProperty(value = "최근 월세 보증금")
	private String recentRentDeposit;
	@ApiModelProperty(value = "최근 월세 금액")
	private String recentRent;
	@ApiModelProperty(value = "최근 매매 금액")
	private String recentDeal;

}
