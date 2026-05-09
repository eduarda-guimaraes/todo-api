
package com.seuprojeto.todo.repository;

import com.seuprojeto.todo.entity.*;
import com.seuprojeto.todo.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

    List<Task> findByUserAndStatus(User user, TaskStatus status);

    Optional<Task> findByIdAndUser(Long id, User user);
}
