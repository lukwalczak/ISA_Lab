package walczak.lukasz.ISA_Lab.profession.function;

import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.profession.dto.GetProfessionsResponse;
import walczak.lukasz.ISA_Lab.profession.entity.Profession;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
