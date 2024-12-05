package walczak.lukasz.ISA_Lab.profession.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import walczak.lukasz.ISA_Lab.profession.entity.Profession;

import java.util.UUID;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, UUID> {
    void deleteById(UUID id);
}
