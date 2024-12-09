package org.example.simplerpgcharacter.character.service.api;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.simplerpgcharacter.character.entity.Character;


public interface CharacterService {

    /**
     * Finds single character.
     *
     * @param id character's id
     * @return container with character
     */
    Optional<Character> find(UUID id);

    /**
     * @return all available characters
     */
    List<Character> findAll();

    /**
     * Creates new character.
     *
     * @param character new character
     */
    void create(Character character);

    /**
     * Updates existing character.
     *
     * @param character character to be updated
     */
    void update(Character character);

    /**
     * Deletes existing character.
     *
     * @param id existing character's id to be deleted
     */
    void delete(UUID id);


    /**
     * @param professionId profession id
     * @return list of characters if profession exists
     */
    Optional<List<Character>> findAllByProfession(UUID professionId);

}

