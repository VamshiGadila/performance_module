package com.practice.springbootdemo.performance_module.dto;

import jakarta.validation.constraints.Size;

public class GoalAcceptanceRequest {

    @Size(max = 1000, message = "Comment must be under 1000 characters")
    private String employeeComment;

    public GoalAcceptanceRequest(String employeeComment) {
        this.employeeComment = employeeComment;
    }

    public GoalAcceptanceRequest() {
    }

    public String getEmployeeComment() {
        return employeeComment;
    }

    public void setEmployeeComment(String employeeComment) {
        this.employeeComment = employeeComment;
    }
}
