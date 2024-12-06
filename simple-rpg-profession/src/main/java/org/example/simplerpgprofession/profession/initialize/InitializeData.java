package org.example.simplerpgprofession.profession.initialize;

import org.example.simplerpgprofession.profession.entity.Profession;
import org.example.simplerpgprofession.profession.service.api.ProfessionService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class InitializeData implements InitializingBean {

    /**
     * Service for professions operations.
     */
    private final ProfessionService professionService;

    /**
     * @param professionService service for managing professions
     */
    @Autowired
    public InitializeData(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (professionService.findAll().isEmpty()) {
            Profession bard = Profession.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .name("Bard")
                    .baseArmor(10)
                    .build();

            Profession cleric = Profession.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .name("Cleric")
                    .baseArmor(15)
                    .build();

            Profession warrior = Profession.builder()
                    .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                    .name("Warrior")
                    .baseArmor(50)
                    .build();

            Profession rogue = Profession.builder()
                    .id(UUID.fromString("8ecfa2de-4fb3-40ae-b739-59b056d56ae6"))
                    .name("Rogue")
                    .baseArmor(30)
                    .build();

            professionService.create(bard);
            professionService.create(cleric);
            professionService.create(warrior);
            professionService.create(rogue);
        }
    }

}

