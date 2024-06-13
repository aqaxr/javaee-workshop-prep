package com.dedalus.restclient;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@RegisterRestClient(baseUri = "https://api.api-ninjas.com/v1")
@ApplicationScoped
public interface ApiNinjaAnimalClient {
    @GET
    @Path("animals")
    public Object getAnimalInfo(@QueryParam("name") String animalName, @HeaderParam("X-Api-Key") String apiKey);

}
