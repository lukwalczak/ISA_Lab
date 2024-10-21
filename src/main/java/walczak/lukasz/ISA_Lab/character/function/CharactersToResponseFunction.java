package walczak.lukasz.ISA_Lab.character.function;

import org.springframework.stereotype.Component;
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
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
