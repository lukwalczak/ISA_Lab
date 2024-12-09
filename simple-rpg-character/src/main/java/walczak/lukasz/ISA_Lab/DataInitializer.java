package walczak.lukasz.ISA_Lab;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.character.entity.Character;
import walczak.lukasz.ISA_Lab.profession.entity.Profession;
import walczak.lukasz.ISA_Lab.character.service.CharacterService;
import walczak.lukasz.ISA_Lab.profession.service.ProfessionService;

import java.util.UUID;

@Component
public class DataInitializer {

    private final ProfessionService professionService;
    private final CharacterService characterService;

    @Autowired
    public DataInitializer(ProfessionService professionService, CharacterService characterService) {
        this.professionService = professionService;
        this.characterService = characterService;
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

        if(characterService.findAll().size() > 0) {
            return;
        }
        Character aragorn = Character.builder().id(UUID.randomUUID()).name("Aragorn").level(20).profession(warrior).build();
        Character legolas = Character.builder().id(UUID.randomUUID()).name("Legolas").level(18).profession(archer).build();
        Character gandalf = Character.builder().id(UUID.randomUUID()).name("Gandalf").level(25).profession(mage).build();
        Character frodo = Character.builder().id(UUID.randomUUID()).name("Frodo").level(10).profession(warrior).build();

        characterService.create(aragorn);
        characterService.create(legolas);
        characterService.create(gandalf);
        characterService.create(frodo);
    }
}
