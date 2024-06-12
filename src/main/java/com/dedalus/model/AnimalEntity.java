package com.dedalus.model;

import javax.persistence.*;

/**
 * New Table for animals
 */

@Entity
@Table(name = "animals")
//Some Dummy commit
public class AnimalEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name= "animal_type")
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    private String comment;


    private boolean available = true;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Long getId() {
        return this.id;
    }
    public AnimalType getAnimalType() {
        return animalType;
    }
    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }
}
