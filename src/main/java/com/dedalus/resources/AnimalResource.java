package com.dedalus.resources;

import com.dedalus.mapper.AnimalDTOMapper;
import com.dedalus.mapper.AvailableAnimalMapper;
import com.dedalus.model.AnimalDTO;
import com.dedalus.model.AnimalEntity;
import com.dedalus.model.AvailableAnimalDTO;
import com.dedalus.persistence.AnimalRepository;
import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheResult;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/animal")
@RequestScoped
public class AnimalResource {
    @Inject
    AnimalRepository repository;

    @Inject
    AvailableAnimalMapper availableAnimalMapper;

    @Inject
    AnimalDTOMapper animalDTOMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CacheResult(cacheName = "animals")
    public List<AnimalDTO> findAll() {
        return this.animalDTOMapper.map( this.repository.findAll());
    }

    @Path("available")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CacheResult(cacheName = "available-animals")
    public List<AvailableAnimalDTO> findAvailable() {return this.availableAnimalMapper.map(this.repository.findAvailable());}

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AnimalDTO findById(@PathParam("id") Long id) {

        AnimalEntity animal = this.repository.findById(id);

        if (animal == null) {
            throw new NotFoundException("The animal " + id + " does not exist");
        }
        return this.animalDTOMapper.map(animal);
    }

    @POST
    @Transactional
    @CacheInvalidate(cacheName="available-animals")
    @CacheInvalidate(cacheName="animals")
    public AnimalEntity save(@Valid AnimalEntity entity) {
        return this.repository.save(entity);
    }

    @Path("{id}/rename/{newName}")
    @PUT
    @Transactional
    public AnimalDTO update(@PathParam("id") Long id, @PathParam("newName") String newName) {
        return  animalDTOMapper.map( this.repository.rename(id, newName));
    }
}
