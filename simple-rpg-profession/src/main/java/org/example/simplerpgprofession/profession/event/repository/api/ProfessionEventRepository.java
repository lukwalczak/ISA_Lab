package org.example.simplerpgprofession.profession.event.repository.api;

import org.example.simplerpgprofession.profession.entity.Profession;

import java.util.UUID;

public interface ProfessionEventRepository {

    /**
     * Delete profession.
     *
     * @param id profession's id
     */
    void delete(UUID id);

    void create(Profession profession);
}
