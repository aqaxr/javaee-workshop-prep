package com.dedalus.mapper;

import com.dedalus.model.AnimalDTO;
import com.dedalus.model.AnimalEntity;
import com.dedalus.model.AnimalInfoDTO;
import com.dedalus.resources.AnimalInfoResource;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Dependent
public class AnimalDTOMapper {

    @Inject
    private AnimalInfoResource animalInfoResource;

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
        List<AnimalInfoDTO> animalInfo = animalInfoResource.getAnimalInfo(entity.getName());
        if (animalInfo != null && !animalInfo.isEmpty()) {
            dto.setAnimalInfo(animalInfo.get(0));
        }
        else {
            animalInfo = animalInfoResource.getAnimalInfo(entity.getAnimalType().name());
            if (animalInfo != null && !animalInfo.isEmpty()) {
                dto.setAnimalInfo(animalInfo.get(0));
            }
        }
        return dto;
    }

    public List<AnimalDTO> map(List<AnimalEntity> entities) {
        return entities.stream().map(this::map).collect(Collectors.toList());
    }
}
