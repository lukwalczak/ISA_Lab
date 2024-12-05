package walczak.lukasz.ISA_Lab.profession.event.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Repository;
import walczak.lukasz.ISA_Lab.profession.event.api.ProfessionEventRepository;

import java.util.UUID;

@Repository
public class ProfessionEventRestRepository implements ProfessionEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public ProfessionEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/profession-events/{id}", id);
    }
}
