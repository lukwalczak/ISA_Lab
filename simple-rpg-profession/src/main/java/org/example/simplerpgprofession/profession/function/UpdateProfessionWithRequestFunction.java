package org.example.simplerpgprofession.profession.function;

import org.example.simplerpgprofession.profession.dto.PutProfessionRequest;
import org.example.simplerpgprofession.profession.entity.Profession;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateProfessionWithRequestFunction implements BiFunction<UUID, PutProfessionRequest, Profession> {
    @Override
    public Profession apply(UUID uuid, PutProfessionRequest request) {
        return Profession.builder().baseArmor(request.getBaseArmor()).build();
    }
}
