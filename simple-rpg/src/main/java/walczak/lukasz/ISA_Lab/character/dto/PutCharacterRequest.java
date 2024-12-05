package walczak.lukasz.ISA_Lab.character.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutCharacterRequest {

        private String name;

        private Integer level;

        private UUID professionId;
}
