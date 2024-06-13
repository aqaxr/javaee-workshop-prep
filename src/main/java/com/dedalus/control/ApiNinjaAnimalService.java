package com.dedalus.control;

import com.dedalus.restclient.ApiNinjaAnimalClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApiNinjaAnimalService {
    @ConfigProperty(name = "API_NINJA_KEY")
    String apiNinjaApiKey;

    @RestClient
    private ApiNinjaAnimalClient animalApiNinjaClient;

    public Object getAnimalInfo(String animalName) {
        return this.animalApiNinjaClient.getAnimalInfo(animalName, this.apiNinjaApiKey);
    }
}
