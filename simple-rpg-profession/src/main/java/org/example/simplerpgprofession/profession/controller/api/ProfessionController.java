package org.example.simplerpgprofession.profession.controller.api;

import org.example.simplerpgprofession.profession.dto.GetProfessionResponse;
import org.example.simplerpgprofession.profession.dto.GetProfessionsResponse;
import org.example.simplerpgprofession.profession.dto.PostProfessionRequest;
import org.example.simplerpgprofession.profession.dto.PutProfessionRequest;
import org.example.simplerpgprofession.profession.entity.Profession;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ProfessionController {

    /**
     * @return list of professions
     */
    @GetMapping("api/professions")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProfessionsResponse getProfessions();

    /**
     * @param id profession's id
     * @return single profession
     */
    @GetMapping("/api/professions/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProfessionResponse getProfession(
            @PathVariable("id")
            UUID id
    );


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

    @PostMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void addProfession(
            @RequestBody PostProfessionRequest request
    );

    @PutMapping("/api/professions/{id}}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateProfession(
            @PathVariable("id")
            UUID id,
            @RequestBody PutProfessionRequest request
    );

}

