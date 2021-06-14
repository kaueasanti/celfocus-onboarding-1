package com.training.springbootbuyitem.controller;

import com.training.springbootbuyitem.constant.ItemStorageConstant;
import com.training.springbootbuyitem.entity.response.ErrorMessage;
import com.training.springbootbuyitem.error.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestControllerAdvice {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleNotFoundError(Exception e) {
		return buildErrorMessageResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleBadRequest(Exception e) {
		return buildErrorMessageResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorMessage> handleConflict(Exception e) {
		return buildErrorMessageResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleInternalError(Exception e) {
		return buildErrorMessageResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<ErrorMessage> buildErrorMessageResponseEntity(String msg, HttpStatus httpStatus) {
		log.info(msg);
		return new ResponseEntity<>(
				ErrorMessage.builder()
						.message(msg)
						.code(httpStatus.value())
						.traceId(MDC.get(ItemStorageConstant.TRACE_ID))
						.operation(MDC.get(ItemStorageConstant.OPERATION))
						.build(),
				httpStatus);
	}

}
