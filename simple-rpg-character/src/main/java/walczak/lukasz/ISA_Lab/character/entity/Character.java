package walczak.lukasz.ISA_Lab.character.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import walczak.lukasz.ISA_Lab.profession.entity.Profession;

import java.util.UUID;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(callSuper = true)
@EqualsAndHashCode()
@Entity
@Table(name = "characters")
public class Character {

    @Id
    private UUID id;

    private String name;

    private int level;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professions")
    private Profession profession;

}
