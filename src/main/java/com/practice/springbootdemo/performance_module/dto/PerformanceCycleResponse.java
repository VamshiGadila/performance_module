package com.practice.springbootdemo.performance_module.dto;

import com.practice.springbootdemo.performance_module.entities.CycleStatus;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class PerformanceCycleResponse {

    private Long id;
    private String cycleName;
    private LocalDate startDate;
    private LocalDate endDate;
    private CycleStatus status;

    public PerformanceCycleResponse(Long id, String cycleName, LocalDate startDate, LocalDate endDate, CycleStatus status) {
        this.id = id;
        this.cycleName = cycleName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public PerformanceCycleResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
