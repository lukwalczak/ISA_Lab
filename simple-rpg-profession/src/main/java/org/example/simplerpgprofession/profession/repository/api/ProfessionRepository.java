package org.example.simplerpgprofession.profession.repository.api;

import org.example.simplerpgprofession.profession.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for profession entity. Repositories should be used in business layer (e.g.: in services).
 */
@Repository
public interface ProfessionRepository extends JpaRepository<Profession, UUID> {

}
