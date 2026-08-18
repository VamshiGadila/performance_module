package com.practice.springbootdemo.performance_module.service;

import com.practice.springbootdemo.performance_module.dto.EmployeeRequest;
import com.practice.springbootdemo.performance_module.dto.EmployeeResponse;
import com.practice.springbootdemo.performance_module.entities.Employee;
import com.practice.springbootdemo.performance_module.repository.EmployeeRepository;
import com.practice.springbootdemo.performance_module.exception.EmployeeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public EmployeeResponse create(EmployeeRequest request) {

        Employee employee = Employee.builder()
                .name(request.getName())
                .email(request.getEmail())
                .department(request.getDepartment())
                .designation(request.getDesignation())
                .status(request.getStatus())
                .joiningDate(request.getJoiningDate())
                .build();

        Employee savedEmployee = employeeRepository.save(employee);

        return toResponse(savedEmployee);
    }
    public List<EmployeeResponse> getAll() {

        return employeeRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }
    public EmployeeResponse getById(Long id) {

        Employee employee = findEntityById(id);

        return toResponse(employee);
    }
    public EmployeeResponse update(Long id, EmployeeRequest request) {

        Employee employee = findEntityById(id);

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setDepartment(request.getDepartment());
        employee.setDesignation(request.getDesignation());
        employee.setStatus(request.getStatus());
        employee.setJoinigDate(request.getJoiningDate());

        Employee updatedEmployee = employeeRepository.save(employee);

        return toResponse(updatedEmployee);
    }

    public void delete(Long id) {

        Employee employee = findEntityById(id);

        employeeRepository.delete(employee);
    }

    public Employee findEntityById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id: " + id
                        )
                );
    }

    private EmployeeResponse toResponse(Employee employee) {

        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .designation(employee.getDesignation())
                .status(employee.getStatus())
                .joiningDate(employee.getJoinigDate())
                .build();
    }
}