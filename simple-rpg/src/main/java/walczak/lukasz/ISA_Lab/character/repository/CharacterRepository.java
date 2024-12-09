package walczak.lukasz.ISA_Lab.character.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import walczak.lukasz.ISA_Lab.character.entity.Character;

import java.util.List;
import java.util.UUID;

@Repository
public interface CharacterRepository extends JpaRepository<Character, UUID> {
    public List<Character> findByName(String name);
}
