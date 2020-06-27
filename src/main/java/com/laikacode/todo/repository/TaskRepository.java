package com.laikacode.todo.repository;

import com.laikacode.todo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link Task} repository extension of {@link JpaRepository}
 * @author Francisco
 * @since 2020/06/27
 */

public interface TaskRepository extends JpaRepository<Task, Integer> { }
