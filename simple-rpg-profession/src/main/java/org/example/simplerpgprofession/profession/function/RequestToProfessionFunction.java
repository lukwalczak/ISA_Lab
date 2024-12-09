package org.example.simplerpgprofession.profession.function;

import org.example.simplerpgprofession.profession.dto.PostProfessionRequest;
import org.example.simplerpgprofession.profession.entity.Profession;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class RequestToProfessionFunction implements Function<PostProfessionRequest, Profession> {

    @Override
    public Profession apply(PostProfessionRequest request) {
        return Profession.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .baseArmor(request.getBaseArmor())
                .build();
    }
}
