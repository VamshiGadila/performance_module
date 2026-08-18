package com.practice.springbootdemo.performance_module.exception;

public class EmployeeNotFoundException extends RuntimeException {
    String message;
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
