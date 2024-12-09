package walczak.lukasz.ISA_Lab.profession.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetProfessionResponse {

    private UUID id;

    private String name;

    private Integer baseArmor;

}
