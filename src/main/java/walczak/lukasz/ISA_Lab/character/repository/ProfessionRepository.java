package walczak.lukasz.ISA_Lab.character.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import walczak.lukasz.ISA_Lab.character.entity.Profession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProfessionRepository implements CrudRepository<Profession, UUID> {

    public Optional<Profession> findByID(UUID K){
        return Optional.empty();
    };

    public void save(Profession entity){

    };

    public void delete(Profession entity){};

    public void deleteByID(UUID K){

    };

    public void update(Profession entity){

    };

    public List<Profession> findAll(){
        return null;
    };

    public Optional<Profession> findById(UUID id) {
        return Optional.empty();
    }

    public void deleteById(UUID id) {
    }

}

