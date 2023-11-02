package com.consultadd.Taskmanager.repository;

import com.consultadd.Taskmanager.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    public Task findByTaskName(String taskName);
    //to fetch data there is no default method avaiable here in the repo
    public Task findByTaskNameIgnoreCase(String taskName);
}
