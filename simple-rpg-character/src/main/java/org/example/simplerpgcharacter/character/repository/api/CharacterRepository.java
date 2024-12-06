package org.example.simplerpgcharacter.character.repository.api;

import org.example.simplerpgcharacter.profession.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.simplerpgcharacter.character.entity.Character;


import java.util.List;
import java.util.UUID;

@Repository
public interface CharacterRepository extends JpaRepository<Character, UUID> {

    List<Character> findAllByProfession(Profession profession);


}

