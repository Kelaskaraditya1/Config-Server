package com.starkindustries.config_server.exception;

import com.starkindustries.config_server.keys.Keys;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Component
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String,Object> body = new LinkedHashMap<>();

        body.put(Keys.TIME_STAMP, Instant.now());
        body.put(Keys.STATUS,status);

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error->
                        error.getDefaultMessage())
                .collect(Collectors.toList());

        body.put(Keys.ERROR,errors);

        return new ResponseEntity<>(body,status);
    }
}
