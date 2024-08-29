package com.github.felyphenrique.tracker.kernel.exceptions;

public abstract class TrackerException extends RuntimeException {

    protected TrackerException(final String message) {
        super(message);
    }
}
