package org.example.simplerpgcharacter.profession.function;

import org.example.simplerpgcharacter.profession.dto.PostProfessionRequest;
import org.example.simplerpgcharacter.profession.entity.Profession;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class RequestToProfessionFunction implements Function<PostProfessionRequest, Profession> {

    @Override
    public Profession apply(PostProfessionRequest request) {
        return Profession.builder()
                .id(request.getId())
                .name(request.getName())
                .baseArmor(request.getBaseArmor())
                .build();
    }
}
