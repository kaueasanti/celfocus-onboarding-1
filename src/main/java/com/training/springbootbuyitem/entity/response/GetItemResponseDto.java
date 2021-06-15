package com.training.springbootbuyitem.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetItemResponseDto extends CreateItemResponseDto implements Serializable {

	private String name;
	private String state;
	private String description;
	private String market;
	private BigInteger stock;
	private BigDecimal priceTag;

}
