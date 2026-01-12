package br.com.wuzuy.todolistspring.repository;

import br.com.wuzuy.todolistspring.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
