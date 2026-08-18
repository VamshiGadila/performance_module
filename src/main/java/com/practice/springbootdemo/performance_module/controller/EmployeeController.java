package com.practice.springbootdemo.performance_module.controller;


import com.practice.springbootdemo.performance_module.dto.EmployeeRequest;
import com.practice.springbootdemo.performance_module.dto.EmployeeResponse;
import com.practice.springbootdemo.performance_module.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmployeeController {

    private final EmployeeService empservice;

    @Autowired
    public EmployeeController(EmployeeService empservice){
        this.empservice = empservice;
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeResponse> create(@Valid @RequestBody EmployeeRequest request) {
        return new ResponseEntity<>(empservice.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(empservice.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        return ResponseEntity.ok(empservice.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long id,
                                                   @Valid @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(empservice.update(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empservice.delete(id);
        return ResponseEntity.noContent().build();
    }
}