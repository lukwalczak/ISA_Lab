package org.example.simplerpgcharacter.profession.event.repository.api;

import java.util.UUID;

public interface ProfessionEventRepository {

    /**
     * Delete profession.
     *
     * @param id profession's id
     */
    void getProfessionById(UUID id);
}
