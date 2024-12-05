package walczak.lukasz.ISA_Lab.profession.service;


import org.springframework.stereotype.Service;
import walczak.lukasz.ISA_Lab.profession.entity.Profession;
import walczak.lukasz.ISA_Lab.profession.repository.ProfessionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfessionService {

    private final ProfessionRepository professionRepository;

    public ProfessionService(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    public Optional<Profession> find(UUID id) {
        return professionRepository.findById(id);
    }

    public void create(Profession profession){
        if(profession.getId() == null){
            profession.setId(UUID.randomUUID());
        }
        professionRepository.save(profession);
    }

    public List<Profession> findAll(){
        return professionRepository.findAll();
    }

    public void deleteById(UUID id){
        professionRepository.deleteById(id);
    }
}

