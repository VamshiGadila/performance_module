package com.practice.springbootdemo.performance_module.service;

import com.practice.springbootdemo.performance_module.dto.GoalAcceptanceRequest;
import com.practice.springbootdemo.performance_module.dto.GoalRequest;
import com.practice.springbootdemo.performance_module.dto.GoalResponse;
import com.practice.springbootdemo.performance_module.entities.Employee;
import com.practice.springbootdemo.performance_module.entities.Goal;
import com.practice.springbootdemo.performance_module.entities.GoalStatus;
import com.practice.springbootdemo.performance_module.entities.PerformanceCycle;
import com.practice.springbootdemo.performance_module.exception.GoalNotFoundException;
import com.practice.springbootdemo.performance_module.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final EmployeeService employeeService;
    private final PerformanceCycleService cycleService;

    public GoalService(GoalRepository goalRepository, EmployeeService employeeService, PerformanceCycleService cycleService) {
        this.goalRepository = goalRepository;
        this.employeeService = employeeService;
        this.cycleService = cycleService;
    }

    public GoalResponse create(GoalRequest request) {
        Employee employee = employeeService.findEntityById(request.getEmployeeId());
        PerformanceCycle cycle = cycleService.findEntityById(request.getCycleId());

        Employee manager = request.getManagerId() != null
                ? employeeService.findEntityById(request.getManagerId())
                : null;

        Goal goal = Goal.builder()
                .employee(employee)
                .cycle(cycle)
                .manager(manager)
                .description(request.getDescription())
                .dueDate(request.getDueDate())
                .status(request.getStatus() != null ? request.getStatus() : GoalStatus.NOT_STARTED)
                .employeeComment(request.getEmployeeComment())
                .employeeAccepted(false)
                .build();

        return toResponse(goalRepository.save(goal));
    }

    public List<GoalResponse> getAll(Long employeeId, GoalStatus status) {
        List<Goal> goals;

        if (employeeId != null && status != null) {
            goals = goalRepository.findByEmployee_IdAndStatus(employeeId, status);
        } else if (employeeId != null) {
            goals = goalRepository.findByEmployee_Id(employeeId);
        } else if (status != null) {
            goals = goalRepository.findByStatus(status);
        } else {
            goals = goalRepository.findAll();
        }

        return goals.stream()
                .map(this::toResponse)
                .toList();
    }

    public GoalResponse getById(Long id) {
        return toResponse(findEntityById(id));
    }

    public GoalResponse update(Long id, GoalRequest request) {
        Goal goal = findEntityById(id);

        Employee employee = employeeService.findEntityById(request.getEmployeeId());
        PerformanceCycle cycle = cycleService.findEntityById(request.getCycleId());

        Employee manager = request.getManagerId() != null
                ? employeeService.findEntityById(request.getManagerId())
                : null;

        goal.setEmployee(employee);
        goal.setCycle(cycle);
        goal.setManager(manager);
        goal.setDescription(request.getDescription());
        goal.setDueDate(request.getDueDate());

        if (request.getStatus() != null) {
            goal.setStatus(request.getStatus());
        }

        if (request.getEmployeeComment() != null) {
            goal.setEmployeeComment(request.getEmployeeComment());
        }

        return toResponse(goalRepository.save(goal));
    }

    public GoalResponse acceptGoal(Long id, GoalAcceptanceRequest request) {
        Goal goal = findEntityById(id);

        goal.setEmployeeAccepted(true);

        if (request != null && request.getEmployeeComment() != null) {
            goal.setEmployeeComment(request.getEmployeeComment());
        }

        return toResponse(goalRepository.save(goal));
    }

    public void delete(Long id) {
        Goal goal = findEntityById(id);
        goalRepository.delete(goal);
    }

    public Goal findEntityById(Long id) {
        return goalRepository.findById(id)
                .orElseThrow(() ->
                        new GoalNotFoundException(
                                "Goal not found with id: " + id
                        )
                );
    }

    private GoalResponse toResponse(Goal goal) {
        Employee manager = goal.getManager();

        return GoalResponse.builder()
                .id(goal.getId())
                .employeeId(goal.getEmployee().getId())
                .employeeName(goal.getEmployee().getName())
                .cycleId(goal.getCycle().getId())
                .cycleName(goal.getCycle().getCycleName())
                .managerId(manager != null ? manager.getId() : null)
                .managerName(manager != null ? manager.getName() : null)
                .description(goal.getDescription())
                .dueDate(goal.getDueDate())
                .status(goal.getStatus())
                .employeeAccepted(goal.isEmployeeAccepted())
                .employeeComment(goal.getEmployeeComment())
                .createdAt(goal.getCreatedAt())
                .build();
    }
}