package com.betrybe.taskmanager.service;

import com.betrybe.taskmanager.dto.TaskDto;
import com.betrybe.taskmanager.model.TaskModel;
import java.util.List;

public interface TaskServiceInterface {

  TaskDto modelToDto(TaskModel task);

  List<TaskDto> getAllTasks();
}
