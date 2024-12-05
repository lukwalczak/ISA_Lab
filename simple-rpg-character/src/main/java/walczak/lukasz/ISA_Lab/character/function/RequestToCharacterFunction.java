package walczak.lukasz.ISA_Lab.character.function;

import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.character.dto.PutCharacterRequest;
import walczak.lukasz.ISA_Lab.character.entity.Character;
import walczak.lukasz.ISA_Lab.profession.entity.Profession;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToCharacterFunction implements BiFunction<UUID, PutCharacterRequest, Character> {

    @Override
    public Character apply(UUID uuid, PutCharacterRequest putCharacterRequest) {
        return Character.builder()
                .id(uuid)
                .name(putCharacterRequest.getName())
                .level(putCharacterRequest.getLevel())
                .profession(Profession.builder().id(putCharacterRequest.getProfessionId()).build())
                .build();
    }
}
