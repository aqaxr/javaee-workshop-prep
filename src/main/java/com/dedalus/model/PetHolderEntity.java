package com.dedalus.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "petholders")
@Getter
@Setter
@ToString
public class PetHolderEntity {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    @Size(min = 3)
    private String name;
    private String firstName;
    private String address;


    @OneToMany(mappedBy = "petHolder")
    private Collection<AnimalEntity> adoptedPets = new ArrayList<AnimalEntity>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof PetHolderEntity)) return false;
        PetHolderEntity that = (PetHolderEntity) o;
        return (Objects.equals(this.id, that.id));
    }

    @Override
        public int hashCode() {
            return Objects.hashCode(id);
    }

}
