package com.training.springbootbuyitem.entity.response;

import lombok.Data;

@Data
public class ErrorMessage {

	public static class Builder{
		private String traceId;
		private String operation;
		private int code;
		private String message;

		public Builder traceId (String traceId) {
			this.traceId = traceId;

			return this;
		}

		public Builder operation(String operation) {
			this.operation = operation;

			return this;
		}

		public Builder code(int code) {
			this.code = code;

			return this;
		}

		public Builder message(String message) {
			this.message = message;

			return this;
		}

		public ErrorMessage build() {
			ErrorMessage errorMessage = new ErrorMessage();

			return errorMessage;
		}
	}

	private ErrorMessage() {}
}