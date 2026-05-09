
package com.seuprojeto.todo.controller;

import com.seuprojeto.todo.dto.TaskRequestDTO;
import com.seuprojeto.todo.entity.Task;
import com.seuprojeto.todo.enums.TaskStatus;
import com.seuprojeto.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping
    public ResponseEntity<List<Task>> list(
            @RequestParam(required = false) TaskStatus status) {

        return ResponseEntity.ok(service.list(status));
    }

    @PostMapping
    public ResponseEntity<Task> create(
            @RequestBody TaskRequestDTO dto) {

        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> update(
            @PathVariable Long id,
            @RequestBody TaskRequestDTO dto) {

        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
