package org.example.simplerpgcharacter.character.initialize;

import org.example.simplerpgcharacter.character.entity.Character;
import org.example.simplerpgcharacter.character.service.api.CharacterService;
import org.example.simplerpgcharacter.profession.entity.Profession;
import org.example.simplerpgcharacter.profession.service.api.ProfessionService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    /**
     * Service for characters operations.
     */
    private final CharacterService characterService;

    /**
     * Service for professions operations.
     */
    private final ProfessionService professionService;

    /**
     * @param characterService  service for managing characters
     * @param professionService service for managing professions
     */
    @Autowired
    public InitializeData(
            CharacterService characterService,
            ProfessionService professionService
    ) {
        this.characterService = characterService;
        this.professionService = professionService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (characterService.findAll().isEmpty()) {

            Profession bard = Profession.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .build();

            Profession cleric = Profession.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .build();

            Profession warrior = Profession.builder()
                    .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                    .build();

            Profession rogue = Profession.builder()
                    .id(UUID.fromString("8ecfa2de-4fb3-40ae-b739-59b056d56ae6"))
                    .build();

            professionService.create(bard);
            professionService.create(cleric);
            professionService.create(warrior);
            professionService.create(rogue);

            Character calvian = Character.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0"))
                    .name("Calvian")
                    .level(1)
                    .profession(bard)
                    .build();

            Character uhlbrecht = Character.builder()
                    .id(UUID.fromString("cc0b0577-bb6f-45b7-81d6-3db88e6ac19f"))
                    .name("Uhlbrecht")
                    .level(1)
                    .profession(warrior)
                    .build();

            Character eloise = Character.builder()
                    .id(UUID.fromString("f08ef7e3-7f2a-4378-b1fb-2922d730c70d"))
                    .name("Eloise")
                    .level(1)
                    .profession(cleric)
                    .build();

            Character zereni = Character.builder()
                    .id(UUID.fromString("ff327e8a-77c0-4f9b-90a2-89e16895d1e1"))
                    .name("Zereni")
                    .level(1)
                    .profession(rogue)
                    .build();

            characterService.create(calvian);
            characterService.create(uhlbrecht);
            characterService.create(eloise);
            characterService.create(zereni);
        }
    }

}


