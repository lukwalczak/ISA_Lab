package walczak.lukasz.ISA_Lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import walczak.lukasz.ISA_Lab.character.entity.Character;
import walczak.lukasz.ISA_Lab.character.entity.Profession;
import walczak.lukasz.ISA_Lab.character.service.CharacterService;
import walczak.lukasz.ISA_Lab.character.service.ProfessionService;

import java.util.Scanner;
import java.util.UUID;

@Component
public class Cli implements CommandLineRunner {

    private final CharacterService characterService;
    private final ProfessionService professionService;

    public Cli(CharacterService characterService, ProfessionService professionService) {
        this.characterService = characterService;
        this.professionService = professionService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nCommands: [list-professions, list-characters, add-character, delete-character, exit]");
            String command = scanner.nextLine();

            switch (command) {
                case "list-professions":
                    professionService.getAllProfessions().forEach(System.out::println);
                    break;
                case "list-characters":
                    characterService.getAllCharacters().forEach(System.out::println);
                    break;
                case "add-character":
                    System.out.print("Enter character name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter character level: ");
                    int level = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter profession name (e.g., Warrior): ");
                    String professionName = scanner.nextLine();
                    Profession profession = professionService.getAllProfessions().stream()
                            .filter(p -> p.getName().equalsIgnoreCase(professionName))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Invalid profession!"));
                    Character newCharacter = new Character(name, level, profession);
                    characterService.addCharacter(newCharacter);
                    break;
                case "delete-character":
                    System.out.print("Enter character ID to delete: ");
                    UUID id = UUID.fromString(scanner.nextLine());
                    characterService.deleteCharacter(id);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }
    }
}
