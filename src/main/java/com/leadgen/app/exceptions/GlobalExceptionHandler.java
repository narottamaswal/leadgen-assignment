package com.leadgen.app.exceptions;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorInfo> handleRuntimeException(HttpServletRequest request, final RuntimeException e) {
		log.error(e.getMessage(), e);
		ErrorResponse errorResponse = new ErrorResponse(
				ErrorTypeConstants.ERROR_STATUS,
				Arrays.asList(e.getMessage())
		);
		return new ResponseEntity<>(
				new ErrorInfo(ErrorTypeConstants.ERROR_STATUS,errorResponse),HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorInfo> handleInvalidReferralCodeException(HttpServletRequest request,
			ValidationException e) {
		ErrorResponse errorResponse = new ErrorResponse(
				e.getCode(),
				e.getErrorMessages()
		);
		return new ResponseEntity<>(
				new ErrorInfo(ErrorTypeConstants.ERROR_STATUS,errorResponse),HttpStatus.BAD_REQUEST
		);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error(ex.getMessage());
		Optional<FieldError> fieldError = ex.getBindingResult().getFieldErrors().stream().findFirst();
		log.error(ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(
			ErrorTypeConstants.ERROR_STATUS,
			Arrays.asList(fieldError.isPresent()?fieldError.get().getDefaultMessage():"")
		);
		return new ResponseEntity<>(
				new ErrorInfo(ErrorTypeConstants.ERROR_STATUS,errorResponse), HttpStatus.BAD_REQUEST
		);
	}

	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error(ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(
			ErrorTypeConstants.ERROR_STATUS,
			Arrays.asList(ErrorTypeConstants.MISSING_PARAMS)
		);
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}
