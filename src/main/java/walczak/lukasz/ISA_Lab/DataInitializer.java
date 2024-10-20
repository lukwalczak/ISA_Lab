package walczak.lukasz.ISA_Lab;

import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.character.entity.Character;
import walczak.lukasz.ISA_Lab.character.entity.Profession;
import walczak.lukasz.ISA_Lab.character.service.CharacterService;
import walczak.lukasz.ISA_Lab.character.service.ProfessionService;
import jakarta.annotation.PostConstruct;


@Component
public class DataInitializer {

    private final ProfessionService professionService;
    private final CharacterService characterService;

    public DataInitializer(ProfessionService professionService, CharacterService characterService) {
        this.professionService = professionService;
        this.characterService = characterService;
    }

    @PostConstruct
    public void init() {
        // Create professions
        Profession warrior = new Profession("Warrior", 50);
        Profession mage = new Profession("Mage", 10);
        Profession archer = new Profession("Archer", 30);

        professionService.getAllProfessions().forEach(System.out::println);

        professionService.addProfession(warrior);
        professionService.addProfession(mage);
        professionService.addProfession(archer);

        Character aragorn = new Character("Aragorn", 20, warrior);
        Character legolas = new Character( "Legolas", 18, archer);
        Character gandalf = new Character( "Gandalf", 25, mage);
        Character frodo = new Character( "Frodo", 10, warrior);


        characterService.addCharacter(aragorn);
        characterService.addCharacter(legolas);
        characterService.addCharacter(gandalf);
        characterService.addCharacter(frodo);
    }
}

