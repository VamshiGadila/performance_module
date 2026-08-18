package com.practice.springbootdemo.performance_module.service;

import com.practice.springbootdemo.performance_module.dto.PerformanceCycleRequest;
import com.practice.springbootdemo.performance_module.dto.PerformanceCycleResponse;
import com.practice.springbootdemo.performance_module.entities.PerformanceCycle;
import com.practice.springbootdemo.performance_module.exception.PerformanceCycleNotFoundException;
import com.practice.springbootdemo.performance_module.repository.PerformanceCycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceCycleService {

    private final PerformanceCycleRepository cycleRepository;

    public PerformanceCycleService(PerformanceCycleRepository cycleRepository) {
        this.cycleRepository = cycleRepository;
    }

    public PerformanceCycleResponse create(PerformanceCycleRequest request) {
        if (request.getEndDate().isBefore(request.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }

        PerformanceCycle cycle = PerformanceCycle.builder()
                .cycleName(request.getCycleName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .status(request.getStatus())
                .build();

        return toResponse(cycleRepository.save(cycle));
    }

    public List<PerformanceCycleResponse> getAll() {
        return cycleRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public PerformanceCycleResponse getById(Long id) {
        return toResponse(findEntityById(id));
    }

    public PerformanceCycleResponse update(Long id, PerformanceCycleRequest request) {
        PerformanceCycle cycle = findEntityById(id);

        if (request.getEndDate().isBefore(request.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }

        cycle.setCycleName((request.getCycleName()));
        cycle.setStartDate(request.getStartDate());
        cycle.setEndDate(request.getEndDate());
        cycle.setStatus(request.getStatus());

        return toResponse(cycleRepository.save(cycle));
    }

    public void delete(Long id) {
        PerformanceCycle cycle = findEntityById(id);
        cycleRepository.delete(cycle);
    }

    public PerformanceCycle findEntityById(Long id) {
        return cycleRepository.findById(id)
                .orElseThrow(() ->
                        new PerformanceCycleNotFoundException(
                                "Performance cycle not found with id: " + id
                        )
                );
    }

    private PerformanceCycleResponse toResponse(PerformanceCycle cycle) {
        return PerformanceCycleResponse.builder()
                .id(cycle.getId())
                .cycleName(cycle.getCycleName())
                .startDate(cycle.getStartDate())
                .endDate(cycle.getEndDate())
                .status(cycle.getStatus())
                .build();
    }
}