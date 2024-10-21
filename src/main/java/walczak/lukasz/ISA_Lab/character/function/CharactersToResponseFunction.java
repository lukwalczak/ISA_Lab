package walczak.lukasz.ISA_Lab.character.function;

import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.character.dto.GetCharacterResponse;
import walczak.lukasz.ISA_Lab.character.dto.GetCharactersResponse;
import walczak.lukasz.ISA_Lab.character.entity.Character;

import java.util.List;
import java.util.function.Function;

@Component
public class CharactersToResponseFunction implements Function<List<Character>, GetCharactersResponse> {

    @Override
    public GetCharacterResponse apply(List<Character> characters) {
        return GetCharacterResponse.builder()
                .characters(characters.stream()
                        .map(character -> GetCharacterResponse.Character.builder()
                                .id(character.getId())
                                .name(character.getName())
                                .level(character.getLevel())

                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
