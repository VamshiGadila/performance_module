package com.practice.springbootdemo.performance_module.repository;

import com.practice.springbootdemo.performance_module.entities.Goal;
import com.practice.springbootdemo.performance_module.entities.GoalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByEmployee_Id(Long employeeId);

    List<Goal> findByStatus(GoalStatus status);

    List<Goal> findByEmployee_IdAndStatus(Long employeeId, GoalStatus status);

    List<Goal> findByCycle_Id(Long cycleId);
}
