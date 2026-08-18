package com.practice.springbootdemo.performance_module.repository;

import com.practice.springbootdemo.performance_module.entities.PerformanceCycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceCycleRepository extends JpaRepository<PerformanceCycle, Long> {
}
