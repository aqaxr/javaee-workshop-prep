package com.dedalus.mapper;

import com.dedalus.model.AnimalEntity;
import com.dedalus.model.AvailableAnimalDTO;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class AvailableAnimalMapper {
    public AvailableAnimalDTO map(AnimalEntity entity){
        AvailableAnimalDTO dto = new AvailableAnimalDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAnimalType(entity.getAnimalType());

        return dto;
    }

    public List<AvailableAnimalDTO> map(List<AnimalEntity> entities){
        return entities.stream().map(entity -> map(entity)).collect(Collectors.toList());
    }
}
