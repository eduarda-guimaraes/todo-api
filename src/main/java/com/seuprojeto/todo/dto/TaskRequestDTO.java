
package com.seuprojeto.todo.dto;

import com.seuprojeto.todo.enums.TaskStatus;
import lombok.Data;

@Data
public class TaskRequestDTO {
    private String titulo;
    private String descricao;
    private TaskStatus status;
}
