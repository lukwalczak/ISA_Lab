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
            System.out.println("\nCommands: [list-professions, list-characters, add-character, delete-character, delete-character-by-name, exit]");
            String command = scanner.nextLine();

            switch (command) {
                case "delete-character-by-name":
                    System.out.print("Enter character name to delete: ");
                    String characterName = scanner.nextLine();
                    try {
                        characterService.deleteByName(characterName);
                    } catch (Exception e) {
                        System.out.println("Error deleting character: " + e.getMessage());
                    }
                    break;
                case "list-professions":
                    try {
                        professionService.findAll().forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println("Error listing professions: " + e.getMessage());
                    }
                    break;
                case "list-characters":
                    try {
                        characterService.getAllCharacters().forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println("Error listing characters: " + e.getMessage());
                    }
                    break;
                case "add-character":
                    System.out.print("Enter character name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter character level: ");
                    int level = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter profession name (e.g., Warrior): ");
                    String professionName = scanner.nextLine();
                    try {
                        Profession profession = professionService.findAll().stream().filter(p -> p.getName().equalsIgnoreCase(professionName)).findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid profession!"));
                        Character newCharacter = Character.builder().id(UUID.randomUUID()).name(name).level(level).profession(profession).build();
                        characterService.create(newCharacter);

                    }catch (Exception e) {
                        System.out.println("Error adding character");
                    }
                    break;
                case "delete-character":
                    System.out.print("Enter character ID to delete: ");
                    UUID id = UUID.fromString(scanner.nextLine());//                    characterService.delete(id
                    try {
                        characterService.delete(id);
                    } catch (Exception e) {
                        System.out.println("Error deleting character");
                    }
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
