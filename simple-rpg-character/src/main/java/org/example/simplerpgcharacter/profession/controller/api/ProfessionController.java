package org.example.simplerpgcharacter.profession.controller.api;

import org.example.simplerpgcharacter.profession.dto.PostProfessionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ProfessionController {

    /**
     * Deletes selected profession.
     *
     * @param id profession's id
     */
    @DeleteMapping("/api/professions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProfession(
            @PathVariable("id")
            UUID id
    );

    @PostMapping("/api/professions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void createProfession(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PostProfessionRequest postProfessionRequest
    );



}

