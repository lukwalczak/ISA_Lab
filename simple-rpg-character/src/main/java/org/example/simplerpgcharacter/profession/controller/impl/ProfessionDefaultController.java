package org.example.simplerpgcharacter.profession.controller.impl;

import lombok.extern.java.Log;
import org.example.simplerpgcharacter.profession.controller.api.ProfessionController;
import org.example.simplerpgcharacter.profession.service.api.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class ProfessionDefaultController implements ProfessionController {

    /**
     * Service for managing professions.
     */
    private final ProfessionService service;


    /**
     * @param service service for managing professions
     */
    @Autowired
    public ProfessionDefaultController(ProfessionService service) {
        this.service = service;
    }

    @Override
    public void deleteProfession(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        profession -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}

