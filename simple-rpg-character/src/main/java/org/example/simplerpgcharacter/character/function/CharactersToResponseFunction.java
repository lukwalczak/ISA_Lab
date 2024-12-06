package org.example.simplerpgcharacter.character.function;

import org.example.simplerpgcharacter.character.dto.GetCharacterResponse;
import org.example.simplerpgcharacter.character.dto.GetCharactersResponse;
import org.example.simplerpgcharacter.character.entity.Character;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.function.Function;

/**
 * Coverts {@link List<Character>} to {@link GetCharactersResponse}.
 */
@Component
public class CharactersToResponseFunction implements Function<List<Character>, GetCharactersResponse> {

    @Override
    public GetCharactersResponse apply(List<Character> entities) {
        return GetCharactersResponse.builder()
                .characters(entities.stream()
                        .map(character -> GetCharactersResponse.Character.builder()
                                .id(character.getId())
                                .name(character.getName())
                                .level(character.getLevel())
                                .profession(GetCharactersResponse.Profession.builder()
                                        .id(character.getProfession().getId())
                                        .name(character.getProfession().getName())
                                        .baseArmor(character.getProfession().getBaseArmor())
                                        .build())
                                .build())
                        .toList())
                .build();
    }

}

