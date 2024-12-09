package org.example.simplerpgcharacter.character.dto;

import lombok.*;

import java.util.UUID;
import org.example.simplerpgcharacter.character.entity.Character;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutCharacterRequest {

    private UUID id;

    private String name;

    private int level;

    private UUID professionId;
}

