package org.example.simplerpgcharacter.character.function;

import org.example.simplerpgcharacter.character.dto.PatchCharacterRequest;
import org.example.simplerpgcharacter.character.entity.Character;
import java.util.function.BiFunction;

/**
 * Returns new instance of {@link Character} based on provided value and updated with values from
 * {@link PatchCharacterRequest}.
 */
public class UpdateCharacterWithRequestFunction implements BiFunction<Character, PatchCharacterRequest, Character> {

    @Override
    public Character apply(Character entity, PatchCharacterRequest request) {
        return Character.builder()
                .id(entity.getId())
                .name(request.getName())
                .level(entity.getLevel())
                .profession(entity.getProfession())
                .build();
    }

}


