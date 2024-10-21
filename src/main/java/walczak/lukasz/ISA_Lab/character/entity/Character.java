package walczak.lukasz.ISA_Lab.character.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(callSuper = true)
@EqualsAndHashCode()
public class Character {

    private UUID id;

    private String name;

    private int level;

    private Profession profession;

}
