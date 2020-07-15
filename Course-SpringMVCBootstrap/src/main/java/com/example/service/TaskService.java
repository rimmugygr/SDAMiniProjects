package com.example.service;

import com.example.model.Level;
import com.example.model.Person;
import com.example.model.Task;
import com.example.repository.PersonRepo;
import com.example.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;
    private final PersonRepo personRepo;

    public TaskService(TaskRepo taskRepo, PersonRepo personRepo) {
        this.taskRepo = taskRepo;
        this.personRepo = personRepo;
    }

    public List<Task> getTasks(){
        return taskRepo.findAll();
    }

    public void addTask(Task task) {
        Person person = personRepo.findById(task.getPerson().getId()).orElse(null);
        Task newTask = new Task(
                task.getLevel(),
                task.getDeadline(),
                LocalDate.now(),
                task.getContent(),
                person);
        taskRepo.save(newTask);
    }

    public Task getTask(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    public void editTask(Task task, Long id) {
        Task editTask = new Task(
                id,
                task.getLevel(),
                task.getDeadline(),
                task.getCreateDate(),
                task.getContent(),
                task.getPerson()
        );
        taskRepo.save(editTask);
    }

    public List<Task> getTasksByLevelOrGetAll(String level) {
        if (level!=null && Arrays.asList(Level.values()).contains(Level.valueOf(level))) {
            return taskRepo.findAllByLevel(Level.valueOf(level));
        } else {
            return this.getTasks();
        }
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
