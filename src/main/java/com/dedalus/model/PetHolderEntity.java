package com.dedalus.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "petholder")
@Getter
@Setter
public class PetHolderEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String firstName;
    private String adress;

    @OneToMany
    private Collection<AnimalEntity> adoptedPets;

}
