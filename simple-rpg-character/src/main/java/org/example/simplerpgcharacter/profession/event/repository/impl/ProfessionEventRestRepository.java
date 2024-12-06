package org.example.simplerpgcharacter.profession.event.repository.impl;

import org.example.simplerpgcharacter.profession.entity.Profession;
import org.example.simplerpgcharacter.profession.event.repository.api.ProfessionEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;


import java.util.UUID;

@Repository
public class ProfessionEventRestRepository implements ProfessionEventRepository {

    /**
     * Configured rest template.
     */
    private final RestTemplate restTemplate;

    @Value("${rpg.profession.url}")
    private String professionServiceUrl;

    @Autowired
    public ProfessionEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public Profession getProfessionById(UUID id){
        try {
            // Make the GET request to fetch the profession
            ResponseEntity<Profession> response = restTemplate.getForEntity(professionServiceUrl + "/api/professions/{id}", Profession.class, id);

            // Check if the response is successful
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody(); // Return the Profession data
            } else {
                // Handle unsuccessful responses (e.g., 404 or 500)
                throw new RuntimeException("Failed to fetch Profession, status code: " + response.getStatusCode());
            }
        } catch (Exception e) {
            // Handle exceptions, such as network issues
            throw new RuntimeException("Error occurred while fetching profession", e);
        }

    }
}
