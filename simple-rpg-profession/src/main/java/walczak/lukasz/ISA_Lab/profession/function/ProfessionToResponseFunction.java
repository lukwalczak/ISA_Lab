package walczak.lukasz.ISA_Lab.profession.function;

import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.profession.dto.GetProfessionResponse;
import walczak.lukasz.ISA_Lab.profession.entity.Profession;

import java.util.function.Function;
@Component
public class ProfessionToResponseFunction  implements Function<Profession, GetProfessionResponse> {

    public GetProfessionResponse apply(Profession profession) {
        return GetProfessionResponse.builder()
                .id(profession.getId())
                .name(profession.getName())
                .baseArmor(profession.getBaseArmor())
                .build();
    }
}
