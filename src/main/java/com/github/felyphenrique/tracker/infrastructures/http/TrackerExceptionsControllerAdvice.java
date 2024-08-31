package com.github.felyphenrique.tracker.infrastructures.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.felyphenrique.tracker.kernel.exceptions.TrackerException;
import com.github.felyphenrique.tracker.kernel.exceptions.TrackerNotFoundException;
import com.github.felyphenrique.tracker.kernel.exceptions.TrackerSecurityException;
import com.github.felyphenrique.tracker.kernel.exceptions.TrackerUnregisterException;

@ControllerAdvice()
public class TrackerExceptionsControllerAdvice {

    @ExceptionHandler({ TrackerNotFoundException.class })
    public @ResponseBody() ResponseEntity<ErrorResponse> handleTrackerNotFoundException(
            TrackerNotFoundException exception) {
        final ErrorResponse response = ErrorResponse
                .builder(exception, HttpStatus.NOT_FOUND, exception.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler({ TrackerSecurityException.class })
    public @ResponseBody() ResponseEntity<ErrorResponse> handleTrackerSecurityException(
            TrackerSecurityException exception) {
        final ErrorResponse response = ErrorResponse
                .builder(exception, HttpStatus.UNAUTHORIZED, exception.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }

    @ExceptionHandler({ TrackerUnregisterException.class })
    public @ResponseBody() ResponseEntity<ErrorResponse> handlerTrackerUnregisterException(
            TrackerUnregisterException exception) {
        final ErrorResponse response = ErrorResponse
                .builder(exception, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler({ TrackerException.class })
    public @ResponseBody() ResponseEntity<ErrorResponse> handlerTrackerException(
            TrackerException exception) {
        final ErrorResponse response = ErrorResponse
                .builder(exception, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
