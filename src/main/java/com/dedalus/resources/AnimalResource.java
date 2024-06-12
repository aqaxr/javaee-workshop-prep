package com.dedalus.resources;

import com.dedalus.mapper.AvailableAnimalMapper;
import com.dedalus.model.AnimalEntity;
import com.dedalus.model.AvailableAnimalDTO;
import com.dedalus.persistence.AnimalRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/animal")
@RequestScoped
public class AnimalResource {
    @Inject
    AnimalRepository repository;

    @Inject
    AvailableAnimalMapper availableAnimalMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<AnimalEntity> findAll() {
        return this.repository.findAll();
    }

    @Path("available")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<AvailableAnimalDTO> findAvailable() {return this.availableAnimalMapper.map(this.repository.findAvailable());}

    @POST
    @Transactional
    public AnimalEntity save(AnimalEntity entity) {
        return this.repository.save(entity);
    }
}