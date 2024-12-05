package walczak.lukasz.ISA_Lab.character.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import walczak.lukasz.ISA_Lab.character.entity.Character;
import walczak.lukasz.ISA_Lab.character.repository.CharacterRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Optional<Character> find(UUID id) {
        return characterRepository.findById(id);
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public void create(Character character) {
        // Manually generate UUID before saving
        if (character.getId() == null) {
            character.setId(UUID.randomUUID());
        }
        characterRepository.save(character);
    }

    public void update(Character character) {
        characterRepository.save(character);
    }

    public void delete(UUID id) {
        characterRepository.deleteById(id);
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public List<Character> getCharacterByName(String name) {
        return characterRepository.findByName(name);
    }

    public void deleteByName(String name){
        UUID id = characterRepository.findByName(name).get(0).getId();
        delete(id);
    }

}

