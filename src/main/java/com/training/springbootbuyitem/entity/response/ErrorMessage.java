package com.training.springbootbuyitem.entity.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorMessage {

		private String traceId;
		private String operation;
		private int code;
		private String message;

}