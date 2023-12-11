package com.isa.bootcamp;

import com.isa.bootcamp.entity.Category;
import com.isa.bootcamp.entity.Task;
import com.isa.bootcamp.repository.TaskRepository;
import com.isa.bootcamp.service.TaskManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class ToDoApp {

    public static void main(String[] args) {
        SpringApplication.run(ToDoApp.class, args);
    }

}
