package org.example.simplerpgcharacter.character.service.impl;

import org.example.simplerpgcharacter.character.repository.api.CharacterRepository;
import org.example.simplerpgcharacter.character.service.api.CharacterService;
import org.example.simplerpgcharacter.profession.entity.Profession;
import org.example.simplerpgcharacter.profession.event.repository.api.ProfessionEventRepository;
import org.example.simplerpgcharacter.profession.repository.api.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.simplerpgcharacter.character.entity.Character;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CharacterDefaultService implements CharacterService {

    /**
     * Repository for character entity.
     */
    private final CharacterRepository repository;

    /**
     * Repository for profession entity.
     */
    private final ProfessionRepository professionRepository;

    private final ProfessionEventRepository professionEventRepository;

    /**
     * @param repository           repository for character entity
     * @param professionRepository repository for profession entity
     */
    @Autowired
    public CharacterDefaultService(
            CharacterRepository repository,
            ProfessionRepository professionRepository,
            ProfessionEventRepository professionEventRepository
    ) {
        this.repository = repository;
        this.professionRepository = professionRepository;
        this.professionEventRepository = professionEventRepository;
    }

    @Override
    public Optional<Character> find(UUID id) {
        Optional<Character> character = repository.findById(id);
        if (character.isEmpty()) {
            return Optional.empty();
        }
        try {
            Profession profession = professionEventRepository.getProfessionById(character.get().getProfession().getId());
            character.get().setProfession(profession);
        }catch (Exception e){
            e.printStackTrace();
        }
        return character;
    }


    @Override
    public List<Character> findAll() {
        List<Character> characters = repository.findAll();

        return characters.stream().map(character ->{
            try {
                Profession profession = professionEventRepository.getProfessionById(character.getProfession().getId());
                character.setProfession(profession);
            }catch (Exception e){
                e.printStackTrace();
            }
            return character;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<List<Character>> findAllByProfession(UUID professionId) {
        Optional<List<Character>> characters = professionRepository.findById(professionId)
                .map(repository::findAllByProfession);
        if (characters.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(characters.get().stream().map(character -> {
            try {
                Profession profession = professionEventRepository.getProfessionById(character.getProfession().getId());
                character.setProfession(profession);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return character;
        }).collect(Collectors.toList()));
    }

    @Override
    public void create(Character character) {
        repository.save(character);
    }

    @Override
    public void update(Character character) {
        repository.save(character);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }


}


