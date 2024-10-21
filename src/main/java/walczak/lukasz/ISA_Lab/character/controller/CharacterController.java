package walczak.lukasz.ISA_Lab.character.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import walczak.lukasz.ISA_Lab.character.dto.GetCharacterResponse;
import walczak.lukasz.ISA_Lab.character.dto.GetCharactersResponse;
import walczak.lukasz.ISA_Lab.character.dto.PutCharacterRequest;
import walczak.lukasz.ISA_Lab.character.function.CharacterToResponseFunction;
import walczak.lukasz.ISA_Lab.character.function.CharactersToResponseFunction;
import walczak.lukasz.ISA_Lab.character.function.RequestToCharacterFunction;
import walczak.lukasz.ISA_Lab.character.service.CharacterService;

import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
public class CharacterController {

    private final CharacterService characterService;

    private final CharacterToResponseFunction characterToResponse;

    private final CharactersToResponseFunction charactersToResponse;

    private final RequestToCharacterFunction requestToCharacter;


    /**
     * @param characterService
     * @param characterToResponse
     * @param charactersToResponse
     * @param requestToCharacter
     */
    @Autowired
    public CharacterController(CharacterService characterService, CharacterToResponseFunction characterToResponse, CharactersToResponseFunction charactersToResponse, RequestToCharacterFunction requestToCharacter) {
        this.characterService = characterService;
        this.characterToResponse = characterToResponse;
        this.charactersToResponse = charactersToResponse;
        this.requestToCharacter = requestToCharacter;
    }

    public GetCharactersResponse getCharacters() {
        return charactersToResponse.apply(characterService.findAll());
    }

    public GetCharacterResponse getCharacter(UUID id) {
        return characterService.find(id).map(characterToResponse).orElseThrow(NoSuchElementException::new);
    }

    public void putCharacter(UUID id, PutCharacterRequest request) {
        characterService.create(requestToCharacter.apply(id, request));
    }

    public void deleteCharacter(UUID id) {
        characterService.delete(id);
    }
}

