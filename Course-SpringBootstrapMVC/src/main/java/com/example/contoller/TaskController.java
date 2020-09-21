package com.example.contoller;

import com.example.model.Task;
import com.example.service.PersonService;
import com.example.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TaskController {
    private final TaskService taskService;
    private final PersonService personService;

    public TaskController(TaskService taskService, PersonService personService) {
        this.taskService = taskService;
        this.personService = personService;
    }

    @GetMapping({"/task/{level}","/task"})
    public String getTasks(Model model, @PathVariable(value = "level", required = false) String level) {
        model.addAttribute("tasks", taskService.getTasksByLevelOrGetAll(level));
        return "taskPages/taskList";
    }

    @GetMapping("/addtask")
    public String addTask(Model model) {
        model.addAttribute("persons", personService.getPersonList());
        return "taskPages/addNewTask";
    }

    @PostMapping("/addtask")
    public RedirectView postTask(@ModelAttribute Task task) {
        taskService.addTask(task);
        return new RedirectView("/task");
    }

    @GetMapping("/edittask/{id}")
    public String editTask(@PathVariable("id") String id, Model model) {
        model.addAttribute("task", taskService.getTask(Long.parseLong(id)));
        model.addAttribute("persons", personService.getPersonList());
        return "taskPages/editTask";
    }

    @PostMapping("/edittask/{id}")
    public RedirectView postTask(@PathVariable("id") String id, @ModelAttribute Task task) {
        taskService.editTask(task,Long.parseLong(id));
        return new RedirectView("/task");
    }

    @PostMapping("/deletetask/{id}")
    public RedirectView deletePerson(@PathVariable String id) {
        taskService.deleteTask(Long.parseLong(id));
        return new RedirectView("/task");
    }

}
