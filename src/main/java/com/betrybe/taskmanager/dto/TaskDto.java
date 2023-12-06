package com.betrybe.taskmanager.dto;

/**
 * The type Task dto.
 */
public record TaskDto(
    String id,
    String title,
    String description,
    String ownerName,
    boolean isComplete
) {

}
