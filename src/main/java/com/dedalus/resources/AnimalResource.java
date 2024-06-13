package com.dedalus.resources;

import com.dedalus.mapper.AnimalDTOMapper;
import com.dedalus.mapper.AvailableAnimalMapper;
import com.dedalus.model.AnimalDTO;
import com.dedalus.model.AnimalEntity;
import com.dedalus.model.AvailableAnimalDTO;
import com.dedalus.persistence.AnimalRepository;
import com.dedalus.restclient.ApiNinjaAnimalClient;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

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
    @Transactional
    public List<AnimalDTO> findAll() {
        return this.animalDTOMapper.map( this.repository.findAll());
    }

    @Path("available")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<AvailableAnimalDTO> findAvailable() {return this.availableAnimalMapper.map(this.repository.findAvailable());}

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalEntity findById(@PathParam("id") Long id) {
        AnimalEntity animal = this.repository.findById(id);
        if (animal == null) {
            throw new NotFoundException("The animal " + id + " does not exist");
        }
        return animal;
    }

    @POST
    @Transactional
    public AnimalEntity save(@Valid AnimalEntity entity) {
        return this.repository.save(entity);
    }
}
