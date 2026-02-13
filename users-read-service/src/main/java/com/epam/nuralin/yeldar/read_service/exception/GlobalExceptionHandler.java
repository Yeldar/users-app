package com.epam.nuralin.yeldar.read_service.exception;

import com.epam.nuralin.yeldar.read_service.dto.ErrorDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDto handleException(Exception e) {
        log.error(e.getMessage(), e);
        return new ErrorDto(
            "Sorry This is not working properly. We know about this mistake and we are " +
                "working to fix it soon. Please try again later.",
            null, "500");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handleHttpMessageNotReadableException(ConstraintViolationException e) {
        Map<String, String> errorMap = new HashMap<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            String field = null;
            for (Path.Node next : violation.getPropertyPath()) {
                field = next.getName();
            }
            errorMap.put(field, violation.getMessage());
        }
        return new ErrorDto("Validation Error", errorMap, "400");
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handleHttpMessageNotReadableException(Exception e) {
        return new ErrorDto(e.getMessage(), null, "400");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        if ("id".equals(e.getName())) {
            return new ErrorDto("Invalid value '" + e.getValue() + "' for ID. Must be a positive integer", null, "400");
        }
        return new ErrorDto(e.getMessage(), null, "400");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handle(MissingServletRequestParameterException e) {
        return new ErrorDto("Request parameter (" + e.getParameterName() + ") is missing. 400.",
            null, "Missing Parameter Error");
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDto handleNotFoundException(NotFoundException e) {
        log.debug(e.getMessage(), e);
        return new ErrorDto(e.getMessage(), null, "404");
    }
}
