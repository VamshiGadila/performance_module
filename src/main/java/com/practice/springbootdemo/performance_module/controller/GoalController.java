package com.practice.springbootdemo.performance_module.controller;


import com.practice.springbootdemo.performance_module.dto.GoalAcceptanceRequest;
import com.practice.springbootdemo.performance_module.dto.GoalRequest;
import com.practice.springbootdemo.performance_module.dto.GoalResponse;
import com.practice.springbootdemo.performance_module.entities.GoalStatus;
import com.practice.springbootdemo.performance_module.service.GoalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {

    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping("/create")
    public ResponseEntity<GoalResponse> create(@Valid @RequestBody GoalRequest request) {
        return new ResponseEntity<>(goalService.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GoalResponse>> getAll(
            @RequestParam(required = false) Long employeeId,
            @RequestParam(required = false) GoalStatus status) {
        return ResponseEntity.ok(goalService.getAll(employeeId, status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(goalService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GoalResponse> update(@PathVariable Long id,
                                               @Valid @RequestBody GoalRequest request) {
        return ResponseEntity.ok(goalService.update(id, request));
    }

    @PatchMapping("/{id}/accept")
    public ResponseEntity<GoalResponse> accept(@PathVariable Long id,
                                               @RequestBody(required = false) GoalAcceptanceRequest request) {
        return ResponseEntity.ok(goalService.acceptGoal(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        goalService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
