package org.example.simplerpgprofession.profession.controller.impl;

import lombok.extern.java.Log;
import org.example.simplerpgprofession.profession.controller.api.ProfessionController;
import org.example.simplerpgprofession.profession.dto.GetProfessionResponse;
import org.example.simplerpgprofession.profession.dto.GetProfessionsResponse;
import org.example.simplerpgprofession.profession.entity.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import org.example.simplerpgprofession.profession.function.ProfessionToResponseFunction;
import org.example.simplerpgprofession.profession.function.ProfessionsToResponseFunction;
import org.example.simplerpgprofession.profession.service.impl.ProfessionDefaultService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/professions")
@Log
public class ProfessionDefaultController implements ProfessionController {

    /**
     * Service for managing professions.
     */
    private final ProfessionDefaultService service;

    /**
     * Converts {@link Profession} to {@link GetProfessionResponse}.
     */
    private final ProfessionToResponseFunction professionToResponse;

    /**
     * Converts {@link List<Profession>} to {@link GetProfessionsResponse}.
     */
    private final ProfessionsToResponseFunction professionsToResponse;

    /**
     * Constructor with dependency injection.
     *
     * @param service               service for managing professions
     * @param professionToResponse  function to convert {@link Profession} to {@link GetProfessionResponse}
     * @param professionsToResponse function to convert {@link List <Profession>} to {@link GetProfessionsResponse}
     */
    @Autowired
    public ProfessionDefaultController(
            ProfessionDefaultService service,
            ProfessionToResponseFunction professionToResponse,
            ProfessionsToResponseFunction professionsToResponse
    ) {
        this.service = service;
        this.professionToResponse = professionToResponse;
        this.professionsToResponse = professionsToResponse;
    }

    /**
     * @return list of all professions
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetProfessionsResponse getProfessions() {
        return professionsToResponse.apply(service.findAll());
    }

    /**
     * Retrieve a single profession by its ID.
     *
     * @param id profession's UUID
     * @return the profession data
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetProfessionResponse getProfession(@PathVariable UUID id) {
        return service.find(id)
                .map(professionToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profession not found"));
    }

    /**
     * Deletes a selected profession by its ID.
     *
     * @param id profession's UUID
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfession(@PathVariable UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        profession -> service.delete(id),
                        () -> {
//                            log.warning("Profession not found");
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profession not found");
                        }
                );
    }
}

