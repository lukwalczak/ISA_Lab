package org.example.simplerpgcharacter.character.function;

import org.example.simplerpgcharacter.character.dto.PutCharacterRequest;
import org.example.simplerpgcharacter.profession.entity.Profession;
import org.springframework.stereotype.Component;
import org.example.simplerpgcharacter.character.entity.Character;


import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Converts {@link PutCharacterRequest} to {@link Character}. Caution, some fields are not set as they should be updated
 * by business logic.
 */
@Component
public class RequestToCharacterFunction implements BiFunction<UUID, PutCharacterRequest, Character> {

    @Override
    public Character apply(UUID id, PutCharacterRequest request) {
        return Character.builder()
                .id(id)
                .level(request.getLevel())
                .name(request.getName())
                .profession(Profession.builder()
                        .id(request.getProfessionId())
                        .build())
                .build();
    }

}

