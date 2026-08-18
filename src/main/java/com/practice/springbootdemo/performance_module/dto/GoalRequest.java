package com.practice.springbootdemo.performance_module.dto;

import com.practice.springbootdemo.performance_module.entities.GoalStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class GoalRequest {


    @NotNull(message = "Employee id is required")
    private Long employeeId;

    @NotNull(message = "Cycle id is required")
    private Long cycleId;

    private Long managerId;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description must be under 1000 characters")
    private String description;

    private GoalStatus status;

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;

    @Size(max = 1000, message = "Comment must be under 1000 characters")
    private String employeeComment;

    public GoalStatus getStatus() {
        return status;
    }

    public void setStatus(GoalStatus status) {
        this.status = status;
    }

    public GoalRequest(Long employeeId, Long cycleId, Long managerId, String description, LocalDate dueDate, GoalStatus status, String employeeComment) {
        this.employeeId = employeeId;
        this.cycleId = cycleId;
        this.managerId = managerId;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.employeeComment = employeeComment;
    }


    public GoalRequest() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getCycleId() {
        return cycleId;
    }

    public void setCycleId(Long cycleId) {
        this.cycleId = cycleId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getEmployeeComment() {
        return employeeComment;
    }

    public void setEmployeeComment(String employeeComment) {
        this.employeeComment = employeeComment;
    }
}
