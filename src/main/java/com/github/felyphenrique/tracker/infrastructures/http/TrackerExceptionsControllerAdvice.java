package com.github.felyphenrique.tracker.infrastructures.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.felyphenrique.tracker.kernel.exceptions.TrackerNotFoundException;

@ControllerAdvice()
public class TrackerExceptionsControllerAdvice {

    @ExceptionHandler({ TrackerNotFoundException.class })
    public @ResponseBody() ResponseEntity<ErrorResponse> handleTrackerNotFoundException(
            TrackerNotFoundException exception) {
        final ErrorResponse response = ErrorResponse
                .builder(exception, HttpStatus.NOT_FOUND, exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
