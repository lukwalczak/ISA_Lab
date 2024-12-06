package org.example.simplerpgprofession.profession.event.repository.api;

import java.util.UUID;

public interface ProfessionEventRepository {

    /**
     * Delete profession.
     *
     * @param id profession's id
     */
    void delete(UUID id);
}
