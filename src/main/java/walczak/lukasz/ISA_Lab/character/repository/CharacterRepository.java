package walczak.lukasz.ISA_Lab.character.repository;

import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;
import walczak.lukasz.ISA_Lab.Datastore;

@Repository
public class CharacterRepository implements CrudRepository<Character, UUID> {

        private final Datastore dataStore;

        public Optional<Character> findByID(UUID K){

        };

        public void save(Character entity){

        };

        void delete(Character entity){};

        void deleteByID(UUID K){

        };

        void update(Character entity){

        };

        Iterable<Character> findAll(){

        };
}
