package org.example.simplerpgprofession.profession.function;

import org.example.simplerpgprofession.profession.dto.GetProfessionResponse;
import org.example.simplerpgprofession.profession.dto.GetProfessionsResponse;
import org.example.simplerpgprofession.profession.entity.Profession;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts {@link Profession} to {@link GetProfessionResponse}.
 */
@Component
public class ProfessionsToResponseFunction implements Function<List<Profession>, GetProfessionsResponse> {

    @Override
    public GetProfessionsResponse apply(List<Profession> entities) {
        return GetProfessionsResponse.builder().professions(entities.stream().map(profession -> GetProfessionsResponse.Profession.builder()
                .id(profession.getId())
                .name(profession.getName())
                .build()).collect(Collectors.toList())).build();
    }
}

