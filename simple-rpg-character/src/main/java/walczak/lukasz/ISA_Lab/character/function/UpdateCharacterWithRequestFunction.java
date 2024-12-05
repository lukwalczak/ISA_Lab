package walczak.lukasz.ISA_Lab.character.function;

import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.character.dto.PatchCharacterRequest;
import walczak.lukasz.ISA_Lab.character.entity.Character;

import java.util.function.BiFunction;

@Component
public class UpdateCharacterWithRequestFunction implements BiFunction<Character, PatchCharacterRequest, Character> {
    @Override
    public Character apply(Character character, PatchCharacterRequest patchCharacterRequest) {
        return Character.builder().id(character.getId())
                .name(patchCharacterRequest.getName())
                .level(patchCharacterRequest.getLevel())
                .profession(character.getProfession())
                .build();
    }
}
