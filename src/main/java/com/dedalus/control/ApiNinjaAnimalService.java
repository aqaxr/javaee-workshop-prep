package com.dedalus.control;

import com.dedalus.model.AnimalInfoDTO;
import com.dedalus.restclient.ApiNinjaAnimalClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.jaxrs.spi.ClientConfigException;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class ApiNinjaAnimalService {
    @ConfigProperty(name = "API_NINJA_KEY")
    String apiNinjaApiKey;

    @RestClient
    private ApiNinjaAnimalClient animalApiNinjaClient;

    @Retry(maxRetries = 3,abortOn = ClientConfigException.class)
    @Fallback(fallbackMethod = "getAnimalInfoFallback")
    public java.util.List<AnimalInfoDTO> getAnimalInfo(String animalName) {
        Response response = this.animalApiNinjaClient.getAnimalInfo(animalName, this.apiNinjaApiKey);
        if (response.getStatus() == 200) {
            String jsonResponse = response.readEntity(String.class);
            Jsonb jsonb = JsonbBuilder.create();
            return jsonb.fromJson(jsonResponse, new java.util.ArrayList<AnimalInfoDTO>(){}.getClass().getGenericSuperclass());
        } else {
            throw new RuntimeException("Failed to fetch data: HTTP error code : " + response.getStatus());
        }
        //return this.animalApiNinjaClient.getAnimalInfo(animalName, this.apiNinjaApiKey);
    }
    public java.util.List<AnimalInfoDTO> getAnimalInfoFallback(String animalName) {
        return new java.util.ArrayList<>();
    }
}
