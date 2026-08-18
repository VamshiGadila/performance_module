package com.practice.springbootdemo.performance_module.controller;

import com.practice.springbootdemo.performance_module.dto.PerformanceCycleRequest;
import com.practice.springbootdemo.performance_module.dto.PerformanceCycleResponse;
import com.practice.springbootdemo.performance_module.service.PerformanceCycleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performance_cycles")
public class PerformanceCycleController {

    private final PerformanceCycleService perService;

    @Autowired
    public PerformanceCycleController(PerformanceCycleService perService) {
        this.perService = perService;
    }

    @PostMapping("/create")
    public ResponseEntity<PerformanceCycleResponse> create(
            @Valid @RequestBody PerformanceCycleRequest request) {

        return new ResponseEntity<>(
                perService.create(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<PerformanceCycleResponse>> getAll() {

        return ResponseEntity.ok(
                perService.getAll()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PerformanceCycleResponse> get(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                perService.getById(id)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PerformanceCycleResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody PerformanceCycleRequest request) {

        return ResponseEntity.ok(
                perService.update(id, request)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        perService.delete(id);

        return ResponseEntity.noContent().build();
    }
}