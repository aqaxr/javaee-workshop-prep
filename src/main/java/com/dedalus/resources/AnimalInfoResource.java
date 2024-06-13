package com.dedalus.resources;

import com.dedalus.control.ApiNinjaAnimalService;
import com.dedalus.model.AnimalInfoDTO;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.jboss.resteasy.client.jaxrs.spi.ClientConfigException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Path("/animalinfo")
public class AnimalInfoResource {
    @Inject
    ApiNinjaAnimalService animalApiNinjaService;

    @GET
    @Retry(maxRetries = 3,abortOn = ClientConfigException.class)
    @Fallback(fallbackMethod = "getAnimalInfoFallback")
    public List<AnimalInfoDTO> getAnimalInfo(@QueryParam("name") String animalName) {
        List<AnimalInfoDTO> result =  this.animalApiNinjaService.getAnimalInfo(animalName);
        return result;
    }
    public List<AnimalInfoDTO> getAnimalInfoFallback(String animalName) {
        return new ArrayList<>();
    }
}
