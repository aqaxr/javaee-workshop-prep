package com.dedalus.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 * New Table for animals
 */

@Entity
@Table(name = "animals")
@Getter
@Setter
public class AnimalEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @Column(name= "animal_type")
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    private String comment;
    private boolean available = true;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "PET_HOLDER_ID", referencedColumnName="id", table="animals")
    private PetHolderEntity petHolder;
}
