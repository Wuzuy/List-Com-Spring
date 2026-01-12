package br.com.wuzuy.todolistspring.service;

import br.com.wuzuy.todolistspring.entity.Task;
import br.com.wuzuy.todolistspring.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> listarTodas() {
        return repository.findAll();
    }

    public Task criar(Task task) {
        // Validação
        if (task.getTitle() == null || task.getTitle().length() < 3) {
            // erro simples por enquanto
            throw new IllegalArgumentException("O título deve ter pelo menos 3 caracteres.");
        }

        return repository.save(task);
    }
}