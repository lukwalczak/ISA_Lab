package walczak.lukasz.ISA_Lab.character.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchCharacterRequest {

    private String name;

    private Integer level;

}
