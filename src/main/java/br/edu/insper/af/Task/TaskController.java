package br.edu.insper.af.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping("/tarefa")
    public ArrayList<Task> getTasks(@RequestHeader("Authorization") String token) {
        return taskService.getTasks(token);
    }

    @PostMapping("/tarefa")
    public Task createTask(@RequestBody Task task, @RequestHeader("Authorization") String token) {
        return taskService.createTask(task, token);
    }

    @DeleteMapping("/tarefa/{id}")
    public void deleteTask(@PathVariable String id, @RequestHeader("Authorization") String token) {
        taskService.deleteTask(id, token);
    }

    @GetMapping("/tarefa/{id}")
    public Task getTask(@PathVariable String id, @RequestHeader("Authorization") String token) {
        return taskService.getSpecificTask(id, token);
    }
}
