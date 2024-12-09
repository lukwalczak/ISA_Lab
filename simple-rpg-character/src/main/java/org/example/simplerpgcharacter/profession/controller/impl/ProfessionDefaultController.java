package org.example.simplerpgcharacter.profession.controller.impl;

import lombok.extern.java.Log;
import org.example.simplerpgcharacter.profession.controller.api.ProfessionController;
import org.example.simplerpgcharacter.profession.dto.PostProfessionRequest;
import org.example.simplerpgcharacter.profession.function.RequestToProfessionFunction;
import org.example.simplerpgcharacter.profession.service.api.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    private final RequestToProfessionFunction requestToProfessionFunction;


    /**
     * @param service service for managing professions
     */
    @Autowired
    public ProfessionDefaultController(ProfessionService service, RequestToProfessionFunction requestToProfessionFunction) {
        this.service = service;
        this.requestToProfessionFunction = requestToProfessionFunction;
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

    @Override
    public void createProfession(@PathVariable UUID id, @RequestBody PostProfessionRequest request) {
        service.create(requestToProfessionFunction.apply(request));
    }

}

