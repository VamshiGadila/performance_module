package com.practice.springbootdemo.performance_module.dto;

import com.practice.springbootdemo.performance_module.entities.CycleStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class PerformanceCycleRequest {

    @NotBlank(message = "Cycle name is required")
    private String cycleName;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @NotNull(message = "Status is required")
    private CycleStatus status;

    public PerformanceCycleRequest(String cycleName, LocalDate startDate, LocalDate endDate, CycleStatus status) {
        this.cycleName = cycleName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public PerformanceCycleRequest() {
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public CycleStatus getStatus() {
        return status;
    }

    public void setStatus(CycleStatus status) {
        this.status = status;
    }
}
