package org.example.simplerpgcharacter.profession.repository.api;


import org.example.simplerpgcharacter.profession.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, UUID> {
}

