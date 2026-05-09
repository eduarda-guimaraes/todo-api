
package com.seuprojeto.todo.service;

import com.seuprojeto.todo.dto.TaskRequestDTO;
import com.seuprojeto.todo.entity.*;
import com.seuprojeto.todo.enums.TaskStatus;
import com.seuprojeto.todo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final UserRepository userRepository;

    private User getAuthenticatedUser() {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByUsername(username)
                .orElseThrow();
    }

    public Task create(TaskRequestDTO dto) {

        Task task = Task.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .status(dto.getStatus())
                .user(getAuthenticatedUser())
                .build();

        return repository.save(task);
    }

    public List<Task> list(TaskStatus status) {

        User user = getAuthenticatedUser();

        if (status != null) {
            return repository.findByUserAndStatus(user, status);
        }

        return repository.findByUser(user);
    }

    public Task findById(Long id) {
        return repository.findByIdAndUser(id, getAuthenticatedUser())
                .orElseThrow();
    }

    public Task update(Long id, TaskRequestDTO dto) {

        Task task = findById(id);

        task.setDescricao(dto.getDescricao());
        task.setStatus(dto.getStatus());

        return repository.save(task);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
