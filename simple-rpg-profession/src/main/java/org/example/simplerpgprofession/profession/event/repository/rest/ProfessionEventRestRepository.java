package org.example.simplerpgprofession.profession.event.repository.rest;

import org.example.simplerpgprofession.profession.entity.Profession;
import org.example.simplerpgprofession.profession.event.repository.api.ProfessionEventRepository;
import org.example.simplerpgprofession.profession.function.ProfessionToResponseFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class ProfessionEventRestRepository implements ProfessionEventRepository {

    /**
     * Configured rest template.
     */
    private final RestTemplate restTemplate;

    private final ProfessionToResponseFunction professionToResponseFunction;

    @Autowired
    public ProfessionEventRestRepository(RestTemplate template, ProfessionToResponseFunction professionToResponseFunction) {
        this.restTemplate = template;
        this.professionToResponseFunction = professionToResponseFunction;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/professions/{id}", id);
    }

    @Override
    public void create(Profession profession) {
        try{
            restTemplate.postForObject("/api/professions/{id}", this.professionToResponseFunction.apply(profession), UUID.class, profession.getId());
        }catch (Exception e) {

        }
    }

}
