package org.example.simplerpgprofession.profession.function;

import org.example.simplerpgprofession.profession.dto.GetProfessionResponse;
import org.example.simplerpgprofession.profession.dto.GetProfessionsResponse;
import org.example.simplerpgprofession.profession.entity.Profession;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

/**
 * Converts {@link List <Profession>} to {@link GetProfessionsResponse}.
 */

@Component
public class ProfessionToResponseFunction  implements Function<Profession, GetProfessionResponse> {

    @Override
    public GetProfessionResponse apply(Profession profession) {
        return GetProfessionResponse.builder()
                .id(profession.getId())
                .name(profession.getName())
                .baseArmor(profession.getBaseArmor())
                .build();
    }
}
