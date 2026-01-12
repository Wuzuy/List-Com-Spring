package br.com.wuzuy.todolistspring.controller;

import br.com.wuzuy.todolistspring.dto.TaskResponseDTO;
import br.com.wuzuy.todolistspring.entity.Task;
import br.com.wuzuy.todolistspring.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskResponseDTO> listar() {
        // Busca a entidade no Banco
        List<Task> tarefas = service.listarTodas();

        // Converte Lista de Entidades -> Lista de DTOs
        // stream() e map() são recursos de programação funcional do Java
        /*
        stream() = Abre um fluxo de dados
        map() = Transforma cada item da lista (Task para TaskResponseDTO)
        collect() = Fecha o fluxo e transforma a lista de volta
         */
        return tarefas.stream()
                .map(task -> new TaskResponseDTO(task.getId(), task.getTitle()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public TaskResponseDTO criar(@RequestBody TaskResponseDTO request) {

        // 1. Converte DTO (Entrada) -> Entidade (Banco)
        Task taskEntity = new Task();

        // Em Records, usamos .title(), e não .getTitle()
        taskEntity.setTitle(request.title());

        Task taskSalva = service.criar(taskEntity);

        return new TaskResponseDTO(taskSalva.getId(), taskSalva.getTitle());
    }
}
