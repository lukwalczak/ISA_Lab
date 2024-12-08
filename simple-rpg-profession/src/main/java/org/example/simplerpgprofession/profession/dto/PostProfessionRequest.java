package org.example.simplerpgprofession.profession.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PostProfessionRequest {
    private String name;
    private int baseArmor;
}
