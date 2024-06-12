package com.dedalus.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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


    @OneToMany(mappedBy = "petholder")

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
