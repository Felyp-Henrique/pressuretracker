package com.github.felyphenrique.tracker.domain.entities;

public enum Status {
    INACTIVE(0),
    ACTIVE(1),
    DELETED(2);

    public static final Status STATUS_DEFAULT = Status.INACTIVE;

    private final int value;

    private Status(final int value) {
        this.value = value;
    }

    public boolean isInactive() {
        return this.value == INACTIVE.value;
    }

    public boolean isActive() {
        return this.value == ACTIVE.value;
    }

    public boolean isDeleted() {
        return this.value == DELETED.value;
    }

    public static Status valueOf(final int value) {
        for (final Status status : Status.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return STATUS_DEFAULT;
    }
}
