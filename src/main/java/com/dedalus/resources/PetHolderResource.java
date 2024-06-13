package com.dedalus.resources;

import com.dedalus.model.PetHolderEntity;
import com.dedalus.persistence.AnimalAdoptionService;
import com.dedalus.persistence.PetHolderRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@RequestScoped
@Path("pet-holder")
public class PetHolderResource {

    @Inject
    PetHolderRepository repository;

    @Inject
    AnimalAdoptionService adoptionService;

    @POST
    @Transactional
    public PetHolderEntity insertNewHolder(PetHolderEntity holder){
        return repository.saveNewHolder(holder);
    }

    @GET
    public List<PetHolderEntity> getAllHolders(){
        return  repository.findAll();
    }

    @POST
    @Path("{holderID}/adopt/{animalID}")
    public String adoptHolder(
                         @PathParam("holderID") Long holderID ,
                         @PathParam("animalID") Long animalID    ){
        
       return adoptionService.adoptAnimal(holderID, animalID);

    }
}
