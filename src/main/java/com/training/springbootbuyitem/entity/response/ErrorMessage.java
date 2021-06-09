package com.training.springbootbuyitem.entity.response;

import lombok.Data;

@Data
public class ErrorMessage {

	public static class Builder{
		private String traceId;
		private String operation;
		private int code;
		private String message;

		public Builder(String traceId) {
			this.traceId = traceId;
		}

		public Builder onOperation(String operation) {
			this.operation = operation;

			return this;
		}

		public Builder withCode(int code) {
			this.code = code;

			return this;
		}

		public Builder withMessage(String message) {
			this.message = message;

			return this;
		}

		public ErrorMessage build() {
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.traceId = this.traceId;
			errorMessage.operation = this.operation;
			errorMessage.code = this.code;
			errorMessage.message = this.message;

			return errorMessage;
		}
	}

	private ErrorMessage() {}
}