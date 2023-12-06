package com.betrybe.taskmanager.controller;

import com.betrybe.taskmanager.dto.TaskDto;
import com.betrybe.taskmanager.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Task controller.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

  TaskService service;

  /**
   * Instantiates a new Task controller.
   *
   * @param service the service
   */
  @Autowired
  public TaskController(TaskService service) {
    this.service = service;
  }

  /**
   * Gets all tasks.
   *
   * @return the all tasks
   */
  @GetMapping
  public ResponseEntity<List<TaskDto>> getAllTasks() {
    List<TaskDto> tasks = service.getAllTasks();

    return ResponseEntity.ok(tasks);
  }
}
