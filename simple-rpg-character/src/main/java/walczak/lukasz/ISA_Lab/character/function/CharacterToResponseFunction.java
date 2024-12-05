package walczak.lukasz.ISA_Lab.character.function;


import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.character.dto.GetCharacterResponse;
import walczak.lukasz.ISA_Lab.character.entity.Character;

import java.util.function.Function;

@Component
public class CharacterToResponseFunction implements Function<Character, GetCharacterResponse> {
    @Override
    public GetCharacterResponse apply(Character character) {
        return GetCharacterResponse.builder()
                .id(character.getId())
                .name(character.getName())
                .level(character.getLevel())
                .profession(GetCharacterResponse.Profession.builder().id(character.getProfession().getId()).name(character.getProfession().getName()).baseArmor(character.getProfession().getBaseArmor()).build())
                .build();
    }
}
