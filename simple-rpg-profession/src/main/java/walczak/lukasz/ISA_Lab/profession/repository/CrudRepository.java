package walczak.lukasz.ISA_Lab.profession.repository;

import java.util.Optional;
import java.util.UUID;

public interface CrudRepository<E, K> {
    Optional<E> findByID(UUID K);

    void save(E entity);

    void delete(E entity);

    void deleteByID(UUID K);

    void update(E entity);

    Iterable<E> findAll();
}
