package com.dedalus.mapper;

import com.dedalus.model.AnimalDTO;
import com.dedalus.model.AnimalEntity;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Dependent
public class AnimalDTOMapper {

    public AnimalDTO map(AnimalEntity entity) {
        AnimalDTO dto = new AnimalDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        dto.setAnimalType(entity.getAnimalType());
        dto.setComment(entity.getComment());
        if (!entity.isAvailable()){
            String name = entity.getPetHolder().getName();
            String firstName = entity.getPetHolder().getFirstName();
            String fullName = name + (Objects.isNull(firstName) ? "" : ", " + firstName);
            dto.setPetHolderFullName(fullName);
        }
        return dto;
    }

    public List<AnimalDTO> map(List<AnimalEntity> entities) {
        return entities.stream().map(this::map).collect(Collectors.toList());
    }
}
