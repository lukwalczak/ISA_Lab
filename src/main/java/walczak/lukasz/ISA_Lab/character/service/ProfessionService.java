package walczak.lukasz.ISA_Lab.character.service;


import org.springframework.stereotype.Service;
import walczak.lukasz.ISA_Lab.character.entity.Profession;
import walczak.lukasz.ISA_Lab.character.repository.ProfessionRepository;

import java.util.List;

@Service
public class ProfessionService {

    private final ProfessionRepository professionRepository;

    public ProfessionService(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    public List<Profession> getAllProfessions() {
        return professionRepository.findAll();
    }

    public void addProfession(Profession profession) {
        professionRepository.save(profession);
    }

}

