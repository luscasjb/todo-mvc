package com.todo.controller;

import com.todo.model.Task;
import com.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/task/new")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @GetMapping("/task/{id}")
    public String viewTask(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid task Id:" + id));
        model.addAttribute("task", task);
        return "task-view";
    }

    @PostMapping("/task")
    public String saveTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/";
    }

    @GetMapping("/task/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid task Id:" + id));
        model.addAttribute("task", task);
        return "task-form";
    }

    @GetMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}