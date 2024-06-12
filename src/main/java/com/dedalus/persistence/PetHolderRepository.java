package com.dedalus.persistence;

import com.dedalus.model.PetHolderEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class PetHolderRepository {

    @Inject
    EntityManager em;

    public PetHolderEntity saveNewHolder(PetHolderEntity entity){
        em.persist(entity);
        return entity;
    }
}
