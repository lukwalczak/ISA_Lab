package walczak.lukasz.ISA_Lab.character.repository;

import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CharacterRepository<E,K> {
        Optional<E> findByID(long K);

        void save(E entity);

        void delete(E entity);

        void deleteByID(long K);

        void update(E entity);

        Iterable<E> findAll();
}
