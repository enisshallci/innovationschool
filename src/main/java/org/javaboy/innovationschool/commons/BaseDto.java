package org.javaboy.innovationschool.commons;

import jakarta.validation.constraints.FutureOrPresent;

import java.sql.Timestamp;

public class BaseDto {
    /*
        Shkruaj validations.
     */
    private Long id;

    @FutureOrPresent(message = "The value of the field or property must be a date or time in present or future.")
    private Timestamp createdAt;

    private Long createdBy;

    @FutureOrPresent(message = "The value of the field or property must be a date or time in present or future.")
    private Timestamp updatedAt;

    private Long updatedBy;

    @FutureOrPresent(message = "The value of the field or property must be a date or time in present or future.")
    private Timestamp deletedAt;

    private Long deletedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }
}
