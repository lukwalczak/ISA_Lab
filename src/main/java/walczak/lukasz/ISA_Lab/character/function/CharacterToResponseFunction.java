package walczak.lukasz.ISA_Lab.character.function;


import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class CharacterToResponseFunction implements Function<Character, GetCharacterResponse> {
    @Override
    public GetCharacterResponse apply(Character character) {
        return GetCharacterResponse.builder()
                .id(character.getId())
                .name(character.getName())
                .age(character.getAge())
                .weight(character.getWeight())
                .height(character.getHeight())
                .build();
    }
}
