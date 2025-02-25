package com.todo.service;

import com.todo.model.Task;
import com.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    // Substitute autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Ordena por prioridade de forma descendente
/*    public List<Task> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );
        return taskRepository.findAll(sort);
    }

    public List<Task> create(Task task) {
        taskRepository.save(task);
        return list();
    }

    public List<Task> update() {
        taskRepository.save(task);
        return list();
    }

    public List<Task> delete(Long id) {
        taskRepository.deleteById(id);
        return list();
    }*/
}