package com.dedalus.model;

import lombok.Data;

@Data
public class AvailableAnimalDTO {
    private Long id;
    private String name;
    private AnimalType animalType;
}
