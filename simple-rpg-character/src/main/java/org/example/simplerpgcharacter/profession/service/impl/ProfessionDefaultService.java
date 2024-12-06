package org.example.simplerpgcharacter.profession.service.impl;

import org.example.simplerpgcharacter.profession.entity.Profession;
import org.example.simplerpgcharacter.profession.repository.api.ProfessionRepository;
import org.example.simplerpgcharacter.profession.service.api.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProfessionDefaultService implements ProfessionService {

    /**
     * Repository for profession entity.
     */
    private final ProfessionRepository repository;

    /**
     * @param repository repository for profession entity
     */
    @Autowired
    public ProfessionDefaultService(ProfessionRepository repository) {
        this.repository = repository;
    }

    /**
     * @param id id of the profession
     * @return container with profession entity
     */
    @Override
    public Optional<Profession> find(UUID id) {
        return repository.findById(id);
    }

    /**
     * Stores new profession in the data store.
     *
     * @param profession new profession to be saved
     */
    @Override
    public void create(Profession profession) {
        repository.save(profession);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}

