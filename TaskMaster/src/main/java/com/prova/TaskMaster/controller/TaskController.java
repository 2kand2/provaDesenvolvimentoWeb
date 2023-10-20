package com.prova.TaskMaster.controller;

import com.prova.TaskMaster.entity.Task;
import com.prova.TaskMaster.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {

    // implementar essa parte depois
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("all")
    public ResponseEntity<?> searchAllTask() {
        try {
            List<Task> listTask = taskService.searchAllTask();
            return new ResponseEntity(listTask, HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<?> searchAllTask(@PathVariable long id) {
        try {
            Task task = taskService.searchTask(id);
            return new ResponseEntity(task, HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addTask(@RequestBody Task task){
        try {
            taskService.createTask(task);
            return new ResponseEntity("Task Criada com sucesso!", HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update")
    public ResponseEntity<?> updateProduct(@RequestBody Task task){
        try {
            task = taskService.updateTask(task);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<?> updateStatusTask(@RequestBody  String  status, @PathVariable long id){
        try{
            taskService.updateStatusTask(status, id);
            return new ResponseEntity<>("Status do produto atualizado com sucesso!", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id){
        try {
            String message = taskService.deleteTask(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
