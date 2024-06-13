package com.dedalus.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@ToString
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

    public boolean isAvailable(){
        return petHolder == null;
    }

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "PET_HOLDER_ID", referencedColumnName="id", table="animals")
    private PetHolderEntity petHolder;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalEntity that = (AnimalEntity) o;
        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
