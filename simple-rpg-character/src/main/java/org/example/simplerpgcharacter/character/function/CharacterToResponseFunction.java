package org.example.simplerpgcharacter.character.function;

import org.example.simplerpgcharacter.character.dto.GetCharacterResponse;
import org.springframework.stereotype.Component;
import org.example.simplerpgcharacter.character.entity.Character;



import java.util.function.Function;

/**
 * Converts {@link Character} to {@link GetCharacterResponse}.
 */
@Component
public class CharacterToResponseFunction implements Function<Character, GetCharacterResponse> {

    @Override
    public GetCharacterResponse apply(Character entity) {
        return GetCharacterResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .level(entity.getLevel())
                .profession(GetCharacterResponse.Profession.builder()
                        .id(entity.getProfession().getId())
                        .build())
                .build();
    }

}
