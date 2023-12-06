package com.betrybe.taskmanager.dto;

/**
 * The type Task creation dto.
 */
public record TaskCreationDto(
    String title,
    String description,
    String ownerName
) {

}
