package org.example.simplerpgprofession.profession.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
public class GetProfessionResponse {

    private UUID id;

    private String name;

    private Integer baseArmor;

}
