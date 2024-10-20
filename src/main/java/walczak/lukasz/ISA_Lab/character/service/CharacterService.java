package walczak.lukasz.ISA_Lab.character.service;

import org.springframework.stereotype.Service;
import walczak.lukasz.ISA_Lab.character.entity.Profession;
import walczak.lukasz.ISA_Lab.character.repository.CharacterRepository;
import walczak.lukasz.ISA_Lab.character.entity.Character;

import java.util.List;
import java.util.UUID;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public List<Character> getCharactersByProfession(Profession profession) {
        return characterRepository.findByProfession(profession);
    }

    public void addCharacter(Character character) {
        characterRepository.save(character);
    }

    public void deleteCharacter(UUID id) {
        characterRepository.deleteById(id);
    }
}

