package com.dedalus.mapper;

import com.dedalus.model.PetHolderDTO;
import com.dedalus.model.PetHolderEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PetHolderDTOMapper {
    public PetHolderDTO map(PetHolderEntity entity){
        PetHolderDTO dto = new PetHolderDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setAddress(entity.getAddress());
        dto.setName(entity.getName());

        return dto;
    }

    public List<PetHolderDTO> map(List<PetHolderEntity> entities){
        return entities.stream().map(entity -> map(entity)).collect(Collectors.toList());
    }
}
