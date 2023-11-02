package com.consultadd.Taskmanager.service;

import com.consultadd.Taskmanager.entity.Task;
import com.consultadd.Taskmanager.error.TaskNotFoundException;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);

    public List<Task> fetchTaskList();

    public Task fetchTaskByTaskId(Integer taskId) throws TaskNotFoundException;

    public void deleteTaskById(Integer taskId);

    public Task updateTask(Integer taskId, Task task);

    public Task fetchTaskByTaskName(String taskName);
}
