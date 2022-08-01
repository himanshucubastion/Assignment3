package com.assign3.Assignment3.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AssignDto {

    @Id
    private long assignId;
    private long userId;
    private String assignName;
    private long taskId;
    private String taskName;
    private String description;
    private Double total;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public long getAssignId() {
        return assignId;
    }

    public void setAssignId(long assignId) {
        this.assignId = assignId;
    }

    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


    public AssignDto() {
    }

    public AssignDto(long assignId, String assignName, long taskId, String taskName, String description, Double total) {
        super();
        this.assignId = assignId;
        this.assignName = assignName;
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
        this.total = total;
    }

    @Override
    public String toString() {
        return "AssignDto [assignId=" + assignId + ", assignName=" + assignName + ", taskId=" + taskId + ", taskName="
                + taskName + ", description=" + description + ", total=" + total + "]";
    }

}
