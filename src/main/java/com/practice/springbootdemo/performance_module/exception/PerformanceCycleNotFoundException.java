package com.practice.springbootdemo.performance_module.exception;

public class PerformanceCycleNotFoundException extends RuntimeException {
    public PerformanceCycleNotFoundException(String message) {
        super(message);
    }
}
