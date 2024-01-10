package com.isa.bootcamp.service;

import com.isa.bootcamp.entity.SelectedCondition;
import com.isa.bootcamp.entity.SortOrFilterOption;
import com.isa.bootcamp.entity.Task;
import com.isa.bootcamp.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Getter
@Setter
public class ToDoService {

    private final TaskRepository taskRepository;
    private final TaskManager taskManager;

    public ToDoService(final TaskRepository taskRepository, final TaskManager taskManager) {
        this.taskRepository = taskRepository;
        this.taskManager = taskManager;
    }

    public Task getTaskById(final long id) {
        return taskRepository.findById(id).orElseGet(Task::new);
    }

    public List<Task> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskList.isEmpty() ? new ArrayList<>() : taskList;
    }

    public void saveOrUpdate(final Task task) {
        this.taskRepository.save(task);
    }

    @Transactional
    public void deleteTaskById(final Task task) {
        this.taskRepository.deleteById(task.getId());
    }

    public List<Task> sortOrFilter(final String condition) {
        return taskManager.sortOrFilterByCondition(condition, getAllTasks());
    }

    public SelectedCondition getSelectedCondition(String condition) {
       return new SelectedCondition(Enum.valueOf(SortOrFilterOption.class, condition));
    }

    public boolean isNotDefaultSortOrFilterOption(final String sortOrFilterOption) {
        return Arrays.stream(SortOrFilterOption.values()).map(it -> it.name()).toList().contains(sortOrFilterOption);
    }

    public List<Task> getTasks(final String sortOrFilterOption) {
        return this.sortOrFilter(sortOrFilterOption);
    }
}
