package com.dedalus.model;

import lombok.Data;

@Data
public class AnimalDTO {
    private Long id;
    private String name;
    private AnimalType animalType;
    private String comment;
    private String petHolderFullName;
    private AnimalInfoDTO animalInfo;
}
