package walczak.lukasz.ISA_Lab.character.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import walczak.lukasz.ISA_Lab.character.dto.GetCharacterResponse;
import walczak.lukasz.ISA_Lab.character.dto.GetCharactersResponse;
import walczak.lukasz.ISA_Lab.character.dto.PutCharacterRequest;
import walczak.lukasz.ISA_Lab.character.function.CharacterToResponseFunction;
import walczak.lukasz.ISA_Lab.character.function.CharactersToResponseFunction;
import walczak.lukasz.ISA_Lab.character.function.RequestToCharacterFunction;
import walczak.lukasz.ISA_Lab.character.service.CharacterService;

import java.util.UUID;

@RestController  // Ensures Spring recognizes this as a REST controller bean
@RequestMapping("/api/characters")  // Base mapping for character-related endpoints
@Log
public class CharacterController {

    private final CharacterService characterService;
    private final CharacterToResponseFunction characterToResponse;
    private final CharactersToResponseFunction charactersToResponse;
    private final RequestToCharacterFunction requestToCharacter;

    /**
     * Constructor for CharacterController with dependencies injected.
     *
     * @param characterService service layer for character management
     * @param characterToResponse function for converting Character entity to response DTO
     * @param charactersToResponse function for converting list of Character entities to response DTO
     * @param requestToCharacter function for converting request DTO to Character entity
     */
    @Autowired
    public CharacterController(CharacterService characterService,
                               CharacterToResponseFunction characterToResponse,
                               CharactersToResponseFunction charactersToResponse,
                               RequestToCharacterFunction requestToCharacter) {
        this.characterService = characterService;
        this.characterToResponse = characterToResponse;
        this.charactersToResponse = charactersToResponse;
        this.requestToCharacter = requestToCharacter;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetCharactersResponse getCharacters() {
        return charactersToResponse.apply(characterService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCharacterResponse getCharacter(@PathVariable UUID id) {
        return characterService.find(id)
                .map(characterToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putCharacter(@PathVariable UUID id, @RequestBody PutCharacterRequest request) {
        characterService.create(requestToCharacter.apply(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable UUID id) {
        characterService.find(id)
                .ifPresentOrElse(
                        character -> characterService.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found");
                        }
                );
    }
}
