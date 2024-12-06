package org.example.simplerpgcharacter.profession.event.repository.api;

import org.example.simplerpgcharacter.profession.entity.Profession;

import java.util.UUID;

public interface ProfessionEventRepository {

    /**
     * Delete profession.
     *
     * @param id profession's id
     */
    Profession getProfessionById(UUID id);
}
