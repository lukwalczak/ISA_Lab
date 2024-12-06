package org.example.simplerpgcharacter.profession.event.repository.impl;

import org.example.simplerpgcharacter.profession.event.repository.api.ProfessionEventRepository;
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

    @Autowired
    public ProfessionEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void getProfessionById(UUID id){
        restTemplate.getForEntity("http://localhost:8080/api/professions/{id}", UUID.class, id);
    }
}
