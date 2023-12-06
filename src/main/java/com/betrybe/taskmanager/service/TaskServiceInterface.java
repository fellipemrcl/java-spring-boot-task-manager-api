package com.betrybe.taskmanager.service;

import com.betrybe.taskmanager.dto.TaskDto;
import com.betrybe.taskmanager.model.TaskModel;
import java.util.List;

/**
 * The interface Task service interface.
 */
public interface TaskServiceInterface {

  TaskDto modelToDto(TaskModel task);

  List<TaskDto> getAllTasks();
}
