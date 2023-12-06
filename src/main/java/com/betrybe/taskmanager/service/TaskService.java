package com.betrybe.taskmanager.service;

import com.betrybe.taskmanager.database.TaskDatabaseInterface;
import com.betrybe.taskmanager.dto.TaskCreationDto;
import com.betrybe.taskmanager.dto.TaskDto;
import com.betrybe.taskmanager.model.TaskModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Task service.
 */
@Service
public class TaskService implements TaskServiceInterface {

  TaskDatabaseInterface database;

  @Autowired
  public TaskService(TaskDatabaseInterface database) {
    this.database = database;
  }

  @Override
  public TaskDto modelToDto(TaskModel task) {
    return new TaskDto(
        task.getId(),
        task.getTitle(),
        task.getDescription(),
        task.getOwnerName(),
        task.getIsCompleted()
    );
  }

  @Override
  public List<TaskDto> getAllTasks() {
    List<TaskModel> tasks = database.getAllTasks();

    return tasks.stream().map(this::modelToDto).toList();
  }

  @Override
  public TaskDto getTaskById(String id) {
    TaskModel task = database.getTaskById(id);

    return modelToDto(task);
  }

  @Override
  public String createTask(TaskCreationDto task) {
    TaskModel newTask = database.createTask(
        task.title(),
        task.description(),
        task.ownerName()
    );

    return newTask.getId();
  }

  @Override
  public void setTaskAsComplete(String id) {
    TaskModel task = database.getTaskById(id);
    task.setIsCompleted(true);
  }

  @Override
  public void deleteTask(String id) {
    database.removeTaskById(id);
  }
}
