package org.example.simplerpgcharacter.character.controller.impl;

import lombok.extern.java.Log;
import org.example.simplerpgcharacter.character.controller.api.CharacterController;
import org.example.simplerpgcharacter.character.dto.GetCharacterResponse;
import org.example.simplerpgcharacter.character.dto.GetCharactersResponse;
import org.example.simplerpgcharacter.character.dto.PutCharacterRequest;
import org.example.simplerpgcharacter.character.function.CharacterToResponseFunction;
import org.example.simplerpgcharacter.character.function.CharactersToResponseFunction;
import org.example.simplerpgcharacter.character.function.RequestToCharacterFunction;
import org.example.simplerpgcharacter.character.service.api.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.example.simplerpgcharacter.character.entity.Character;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Log
public class CharacterDefaultController implements CharacterController {

    /**
     * Service for managing characters.
     */
    private final CharacterService service;

    /**
     * Converts {@link Character} to {@link GetCharacterResponse}.
     */
    private final CharacterToResponseFunction characterToResponse;

    /**
     * Coverts {@link List <Character>} to {@link GetCharactersResponse}.
     */
    private final CharactersToResponseFunction charactersToResponse;

    /**
     * Converts {@link PutCharacterRequest} to {@link Character}.
     */
    private final RequestToCharacterFunction requestToCharacter;

    /**
     * @param service              service for managing characters
     * @param characterToResponse  converts {@link Character} to {@link GetCharacterResponse}
     * @param charactersToResponse coverts {@link List <Character>} to {@link GetCharactersResponse}
     * @param requestToCharacter   converts {@link PutCharacterRequest} to {@link Character}
     */
    @Autowired
    public CharacterDefaultController(
            CharacterService service,
            CharacterToResponseFunction characterToResponse,
            CharactersToResponseFunction charactersToResponse,
            RequestToCharacterFunction requestToCharacter
    ) {
        this.service = service;
        this.characterToResponse = characterToResponse;
        this.charactersToResponse = charactersToResponse;
        this.requestToCharacter = requestToCharacter;
    }

    @Override
    public GetCharactersResponse getCharacters() {
        return charactersToResponse.apply(service.findAll());
    }

    @Override
    public GetCharactersResponse getProfessionCharacters(UUID professionId) {
        return service.findAllByProfession(professionId)
                .map(charactersToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetCharacterResponse getCharacter(UUID id) {
        return service.find(id)
                .map(characterToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putCharacter(UUID id, PutCharacterRequest request) {
        service.create(requestToCharacter.apply(id, request));
    }


    @Override
    public void deleteCharacter(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        character -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}

