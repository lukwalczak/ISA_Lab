package walczak.lukasz.ISA_Lab.character.entity;

import lombok.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Profession implements Serializable {

    private UUID id;

    private String name;

    private int baseArmor;


}