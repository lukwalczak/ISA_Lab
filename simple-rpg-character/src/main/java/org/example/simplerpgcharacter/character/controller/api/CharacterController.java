package org.example.simplerpgcharacter.character.controller.api;

import org.example.simplerpgcharacter.character.dto.GetCharacterResponse;
import org.example.simplerpgcharacter.character.dto.GetCharactersResponse;
import org.example.simplerpgcharacter.character.dto.PutCharacterRequest;
import org.example.simplerpgcharacter.character.entity.Character;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface CharacterController {

    /**
     * @return list of characters
     */
    @GetMapping("api/characters")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharactersResponse getCharacters();

    /**
     * @param professionId characters' profession
     * @return list of characters
     */
    @GetMapping("/api/professions/{professionId}/characters")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharactersResponse getProfessionCharacters(
            @PathVariable("professionId")
            UUID professionId
    );

    /**
     * @param id character's id
     * @return single character
     */
    @GetMapping("/api/characters/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharacterResponse getCharacter(
            @PathVariable("id")
            UUID id
    );

    /**
     * @param id      character's id
     * @param request new character
     */
    @PutMapping("/api/characters/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putCharacter(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutCharacterRequest request
    );

    /**
     * Deletes selected character.
     *
     * @param id character's id
     */
    @DeleteMapping("/api/characters/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCharacter(
            @PathVariable("id")
            UUID id
    );

}