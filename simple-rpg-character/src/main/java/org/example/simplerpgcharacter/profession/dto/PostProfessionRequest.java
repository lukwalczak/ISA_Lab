package org.example.simplerpgcharacter.profession.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PostProfessionRequest {
    private UUID id;
    private String name;
    private int baseArmor;
}

