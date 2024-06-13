package com.dedalus.control;

import com.dedalus.mapper.PetHolderDTOMapper;
import com.dedalus.model.PetHolderDTO;
import com.dedalus.model.PetHolderEntity;
import com.dedalus.persistence.PetHolderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PetHolderService {
    @Inject
    PetHolderRepository repository;

    @Inject
    PetHolderDTOMapper mapper;

    public List<PetHolderDTO> findAll(){
        List<PetHolderEntity> petHolders = repository.findAll();
        if (petHolders == null) return new ArrayList<>();

        return petHolders.stream().map(entity -> mapper.map(entity)).collect(Collectors.toList());
    }
    public PetHolderDTO saveNewHolder(PetHolderEntity entity){
        PetHolderEntity inserted = repository.saveNewHolder(entity);
        return mapper.map(inserted);
    }
}
