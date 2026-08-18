package com.practice.springbootdemo.performance_module.dto;

import com.practice.springbootdemo.performance_module.entities.EmployeeStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class EmployeeRequest {

    @NotBlank(message = "Employee name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    private String department;

    private String designation;

    @NotNull(message = "Status is required")
    private EmployeeStatus status;

    @PastOrPresent(message = "Joining date cannot be in the future")
    private LocalDate joiningDate;

    public EmployeeRequest(String name, String email, String department, String designation, EmployeeStatus status, LocalDate joiningDate) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.status = status;
        this.joiningDate = joiningDate;
    }

    public EmployeeRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
}

