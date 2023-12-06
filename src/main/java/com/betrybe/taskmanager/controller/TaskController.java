package com.betrybe.taskmanager.controller;

import com.betrybe.taskmanager.dto.TaskCreationDto;
import com.betrybe.taskmanager.dto.TaskDto;
import com.betrybe.taskmanager.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  /**
   * Gets task by id.
   *
   * @param id the id
   * @return the task by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<TaskDto> getTaskById(@PathVariable String id) {
    TaskDto task = service.getTaskById(id);

    return ResponseEntity.ok(task);
  }

  /**
   * Create task response entity.
   *
   * @param task the task
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<String> createTask(@RequestBody TaskCreationDto task) {
    String taskId = service.createTask(task);

    return ResponseEntity.status(HttpStatus.CREATED).body(taskId);
  }
}
