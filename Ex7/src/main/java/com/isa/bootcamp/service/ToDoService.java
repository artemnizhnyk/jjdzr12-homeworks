package com.isa.bootcamp.service;

import com.isa.bootcamp.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class ToDoService {

    private final TaskRepository taskRepository;


    public com.isa.bootcamp.entity.Task getTaskById(final long id) {
        return taskRepository.findById(id).orElseGet(com.isa.bootcamp.entity.Task::new);
    }

    public List<com.isa.bootcamp.entity.Task> getAllTasks() {
        List<com.isa.bootcamp.entity.Task> taskList = taskRepository.findAll();
        return taskList.isEmpty() ? new ArrayList<>() : taskList;
    }

    public void saveOrUpdate(final com.isa.bootcamp.entity.Task task) {
        this.taskRepository.save(task);
    }

    @Transactional
    public void deleteTaskById(final com.isa.bootcamp.entity.Task task) {
        this.taskRepository.deleteById(task.getId());
    }
}
