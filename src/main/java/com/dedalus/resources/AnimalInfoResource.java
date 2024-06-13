package com.dedalus.resources;

import com.dedalus.control.ApiNinjaAnimalService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@RequestScoped
@Path("/animalinfo")
public class AnimalInfoResource {
    @Inject
    ApiNinjaAnimalService animalApiNinjaService;

    @GET
    public Object getAnimalInfo(@QueryParam("name") String animalName) {
        return this.animalApiNinjaService.getAnimalInfo(animalName);
    }
}
