package com.practice.springbootdemo.performance_module.dto;

import com.practice.springbootdemo.performance_module.entities.EmployeeStatus;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private String department;
    private String designation;
    private EmployeeStatus status;
    private LocalDate joiningDate;

    public EmployeeResponse() {
    }

    public EmployeeResponse(Long id, String name, String email, String department, String designation, EmployeeStatus status, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.status = status;
        this.joiningDate = joiningDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
