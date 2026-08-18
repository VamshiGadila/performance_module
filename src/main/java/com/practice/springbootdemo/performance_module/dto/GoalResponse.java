package com.practice.springbootdemo.performance_module.dto;

import com.practice.springbootdemo.performance_module.entities.GoalStatus;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public class GoalResponse {

    private Long id;

    private Long employeeId;
    private String employeeName;

    private Long cycleId;
    private String cycleName;

    private Long managerId;
    private String managerName;

    private String description;
    private LocalDate dueDate;
    private GoalStatus status;
    private boolean employeeAccepted;
    private String employeeComment;
    private LocalDateTime createdAt;

    public GoalResponse(Long id, Long employeeId, String employeeName, Long cycleId, String cycleName, Long managerId, String managerName, String description, LocalDate dueDate, GoalStatus status, boolean employeeAccepted, String employeeComment, LocalDateTime createdAt) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.cycleId = cycleId;
        this.cycleName = cycleName;
        this.managerId = managerId;
        this.managerName = managerName;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.employeeAccepted = employeeAccepted;
        this.employeeComment = employeeComment;
        this.createdAt = createdAt;
    }

    public GoalResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getCycleId() {
        return cycleId;
    }

    public void setCycleId(Long cycleId) {
        this.cycleId = cycleId;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
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

    public GoalStatus getStatus() {
        return status;
    }

    public void setStatus(GoalStatus status) {
        this.status = status;
    }

    public boolean isEmployeeAccepted() {
        return employeeAccepted;
    }

    public void setEmployeeAccepted(boolean employeeAccepted) {
        this.employeeAccepted = employeeAccepted;
    }

    public String getEmployeeComment() {
        return employeeComment;
    }

    public void setEmployeeComment(String employeeComment) {
        this.employeeComment = employeeComment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
