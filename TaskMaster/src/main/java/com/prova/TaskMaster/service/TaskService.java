package com.prova.TaskMaster.service;

import com.prova.TaskMaster.entity.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TaskService {
    private List<Task> tasks;
    public TaskService(){
        tasks = new ArrayList<>();
    }


    public List<Task> searchAllTask() throws Exception{
        if(tasks.isEmpty()){
            throw new Exception("Não há tarefas");
        }
        return tasks;
    }
    public Task searchTask(long id) throws Exception{
        if(tasks.isEmpty()){
            throw new Exception("Não há tarefas!");
        }
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                return task;
            }
        }

        throw new Exception("Task com o ID especificado não foi encontrado");
    }


    public Task createTask(Task task) throws Exception{
        tasks.add(task);
        return task;
    }

    public Task updateTask(Task task) throws Exception{
        if(tasks.isEmpty()){
            throw new Exception("Não há tarefas!");
        }

        for(Task item : tasks){
            if(item.getId() == task.getId()){
                item.setName(task.getName());
                return task;
            }
        }
        throw  new Exception("tarefas com o id especificado não foi encontrado!");
    }
    public String updateStatusTask(String status, long id) throws Exception{
        if(tasks.isEmpty()){
            throw new Exception("Não há tarefas!");
        }

        for(Task item : tasks){
            if(item.getId() == id){
                item.setStatus(status);
                return status.toString();
            }
        }
        throw  new Exception("tarefas com o id especificado não foi encontrado!");
    }
    public String deleteTask(long id) throws Exception{
        if(tasks.isEmpty()){
            throw new Exception("Não há tarefas para serem removidos");
        }
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                return "tarefa removida com sucesso!";
            }
        }
        throw new Exception("tarefa com o ID especificado não foi encontrado para remover!");
    }


}
