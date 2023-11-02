package com.consultadd.Taskmanager.service;


import com.consultadd.Taskmanager.entity.Task;
import com.consultadd.Taskmanager.error.TaskNotFoundException;
import com.consultadd.Taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> fetchTaskList() {
        return taskRepository.findAll();
    }
    @Override
    public Task fetchTaskByTaskId(Integer taskId) throws TaskNotFoundException {
        Optional<Task> task=taskRepository.findById(taskId);
        if(!task.isPresent()){
            throw new TaskNotFoundException("Task Not Assign");
        }
        //return taskRepository.findById(taskId).get();
        return task.get();
    }

    @Override
    public void deleteTaskById(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task updateTask(Integer taskId, Task task) {
        Task taskDB=taskRepository.findById(taskId).get();

        if(Objects.nonNull(task.getTaskName()) &&
        !"".equalsIgnoreCase(task.getTaskName())) {
            taskDB.setTaskName(task.getTaskName());
        }

        if(Objects.nonNull(task.getTaskDescription()) &&
                !"".equalsIgnoreCase(task.getTaskDescription())) {
            taskDB.setTaskDescription(task.getTaskDescription());
        }

        if(Objects.nonNull(task.getTaskStatus()) &&
                !"".equalsIgnoreCase(task.getTaskStatus())) {
            taskDB.setTaskStatus(task.getTaskStatus());
        }
        /*if(Objects.nonNull(task.getTaskCreatedDate()) &&
                !"".equalsIgnoreCase(task.getTaskCreatedDate())) {
            taskDB.setTaskName(task.getTaskName());
        }*/

        return taskRepository.save(taskDB);



    }

    @Override
    public Task fetchTaskByTaskName(String taskName) {
        return taskRepository.findByTaskNameIgnoreCase(taskName);
    }

}
