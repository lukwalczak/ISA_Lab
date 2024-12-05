package walczak.lukasz.ISA_Lab;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.profession.entity.Profession;
import walczak.lukasz.ISA_Lab.profession.service.ProfessionService;

import java.util.UUID;

@Component
public class DataInitializer {

    private final ProfessionService professionService;

    @Autowired
    public DataInitializer(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @PostConstruct
    public void init() {

        if(professionService.findAll().size() > 0) {
            return;
        }
        Profession warrior = Profession.builder().id(UUID.randomUUID()).name("Warrior").baseArmor(20).build();
        Profession mage = Profession.builder().id(UUID.randomUUID()).name("Mage").baseArmor(10).build();
        Profession archer = Profession.builder().id(UUID.randomUUID()).name("Archer").baseArmor(15).build();

        professionService.create(warrior);
        professionService.create(mage);
        professionService.create(archer);
    }
}
