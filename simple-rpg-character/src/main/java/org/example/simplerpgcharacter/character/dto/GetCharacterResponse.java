package org.example.simplerpgcharacter.character.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCharacterResponse {


    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Profession {

        private UUID id;
        private String name;
        private Integer baseArmor;
    }

    private UUID id;

    private String name;

    private Profession profession;

    private Integer level;

}

