package com.github.felyphenrique.tracker.kernel.entities;

public enum Status {
    INACTIVATED(0),
    ACTIVED(1),
    DELETED(2);

    private final int value;

    private Status(final int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }

    public final boolean isInactivated() {
        return this.value == INACTIVATED.value;
    }

    public final boolean isActived() {
        return this.value == ACTIVED.value;
    }

    public final boolean isDeleted() {
        return this.value == DELETED.value;
    }
}
