package com.example.AdjutorRUTMIIT_bot.dao.entity;

import jakarta.persistence.Column;

public abstract class AbstractEntity<ID> {

    protected boolean isDeleted;

    public abstract ID getId();

    @Column(name = "is_deleted", nullable = false)
    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
