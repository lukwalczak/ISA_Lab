package walczak.lukasz.ISA_Lab.character.function;

import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.character.dto.GetCharactersResponse;
import walczak.lukasz.ISA_Lab.character.entity.Character;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CharactersToResponseFunction implements Function<List<Character>, GetCharactersResponse> {

    @Override
    public GetCharactersResponse apply(List<Character> entities) {
        return GetCharactersResponse.builder()
                .characters(entities.stream().map(character -> GetCharactersResponse.Character.builder()
                        .id(character.getId())
                        .name(character.getName())
                        .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
