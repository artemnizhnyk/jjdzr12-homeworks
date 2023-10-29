package com.isa.bootcamp.controller;

import com.isa.bootcamp.entity.Category;
import com.isa.bootcamp.entity.Task;
import com.isa.bootcamp.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class ToDoController {

    private final ToDoService service;

    @GetMapping("/")
    public String showAllTasks(Model model) {
        List<Task> allTasks = service.getAllTasks();
        model.addAttribute("allTasks", allTasks);
        model.addAttribute("content", "index");
        return "main";
    }

    @PostMapping("/")
    public String showAllTasksPost(@ModelAttribute Task task) {
        service.saveOrUpdate(task);
        return "redirect:/";
    }

    @GetMapping("/new-task/{id}")
    public String addOrEditTask(@PathVariable long id, Model model) {
        Task task = service.getTaskById(id);
        model.addAttribute("editTask", task);
        model.addAttribute("categories", Category.values());
        model.addAttribute("content", "new-task");
        return "main";
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@ModelAttribute Task task) {
        service.deleteTaskById(task);
        return "redirect:/";
    }
}
