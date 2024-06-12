package com.dedalus.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "petholder")
@Getter
@Setter
public class PetHolderEntity {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String name;
    private String firstName;
    private String adress;


    @OneToMany(mappedBy = "petHolder")
//    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<AnimalEntity> adoptedPets = new ArrayList<AnimalEntity>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof PetHolderEntity)) return false;
        PetHolderEntity that = (PetHolderEntity) o;
        return (id.equals(that.id));
    }



}
