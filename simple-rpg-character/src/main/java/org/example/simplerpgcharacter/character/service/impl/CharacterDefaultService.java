package org.example.simplerpgcharacter.character.service.impl;

import org.example.simplerpgcharacter.character.repository.api.CharacterRepository;
import org.example.simplerpgcharacter.character.service.api.CharacterService;
import org.example.simplerpgcharacter.profession.event.repository.api.ProfessionEventRepository;
import org.example.simplerpgcharacter.profession.repository.api.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.simplerpgcharacter.character.entity.Character;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    private final ProfessionEventRepository eventRepository;

    /**
     * @param repository           repository for character entity
     * @param professionRepository repository for profession entity
     */
    @Autowired
    public CharacterDefaultService(
            CharacterRepository repository,
            ProfessionRepository professionRepository,
            ProfessionEventRepository eventRepository
    ) {
        this.repository = repository;
        this.professionRepository = professionRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public Optional<Character> find(UUID id) {
        return repository.findById(id);
    }


    @Override
    public List<Character> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<Character>> findAllByProfession(UUID professionId) {
        return professionRepository.findById(professionId)
                .map(repository::findAllByProfession);
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


