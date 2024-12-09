package walczak.lukasz.ISA_Lab.character.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "professions")
public class Profession implements Serializable {

    @Id
    private UUID id;

    private String name;

    private int baseArmor;

}