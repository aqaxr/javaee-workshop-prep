package com.dedalus.model;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

@Getter
@Setter
public class AnimalInfoDTO {

    @JsonbProperty("characteristics")
    private Characteristics characteristics;

    @JsonbProperty("name")
    private String name;

    @JsonbProperty("locations")
    private List<String> locations;

    @JsonbProperty("taxonomy")
    private Taxonomy taxonomy;

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }
    @Getter
    @Setter
    public static class Characteristics {
        @JsonbProperty("average_litter_size")
        private String averageLitterSize;

        @JsonbProperty("color")
        private String color;

        @JsonbProperty("lifespan")
        private String lifespan;

        @JsonbProperty("temperament")
        private String temperament;

        @JsonbProperty("training")
        private String training;

        @JsonbProperty("diet")
        private String diet;

        @JsonbProperty("common_name")
        private String commonName;

        @JsonbProperty("skin_type")
        private String skinType;

        @JsonbProperty("slogan")
        private String slogan;

        @JsonbProperty("group")
        private String group;

        @JsonbProperty("height")
        private String height;

        @JsonbProperty("most_distinctive_feature")
        private String mostDistinctiveFeature;

        @JsonbProperty("predators")
        private String predators;

        @JsonbProperty("number_of_species")
        private String numberOfSpecies;

        @JsonbProperty("habitat")
        private String habitat;

        @JsonbProperty("main_prey")
        private String mainPrey;

        @JsonbProperty("group_behavior")
        private String groupBehavior;

        @JsonbProperty("other_name(s)")
        private String otherNames;

        @JsonbProperty("gestation_period")
        private String gestationPeriod;

        @JsonbProperty("biggest_threat")
        private String biggestThreat;

        @JsonbProperty("optimum_ph_level")
        private String optimumPhLevel;

        @JsonbProperty("water_type")
        private String waterType;

        // Getters and Setters for each field
        // ...
    }
    @Getter
    @Setter
    public static class Taxonomy {
        @JsonbProperty("phylum")
        private String phylum;

        @JsonbProperty("genus")
        private String genus;

        @JsonbProperty("scientific_name")
        private String scientificName;

        @JsonbProperty("family")
        private String family;

        @JsonbProperty("kingdom")
        private String kingdom;

        @JsonbProperty("class")
        private String className;

        @JsonbProperty("order")
        private String order;
    }

}
