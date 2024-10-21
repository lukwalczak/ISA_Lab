package walczak.lukasz.ISA_Lab.character.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import walczak.lukasz.ISA_Lab.character.entity.Profession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProfessionRepository implements CrudRepository<Profession, UUID> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProfessionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Profession> findByID(UUID id) {
        String sql = "SELECT * FROM professions WHERE id = ?";
        List<Profession> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Profession.class), id.toString());

        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    @Override
    public void save(Profession profession) {
        String sql = "INSERT INTO professions (id, name, base_armor) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, profession.getId().toString(), profession.getName(), profession.getBaseArmor());
    }

    @Override
    public void delete(Profession profession) {
        String sql = "DELETE FROM professions WHERE id = ?";
        jdbcTemplate.update(sql, profession.getId().toString());
    }

    @Override
    public void deleteByID(UUID id) {
        String sql = "DELETE FROM professions WHERE id = ?";
        jdbcTemplate.update(sql, id.toString());
    }

    @Override
    public void update(Profession profession) {
        String sql = "UPDATE professions SET name = ?, base_armor = ? WHERE id = ?";
        jdbcTemplate.update(sql, profession.getName(), profession.getBaseArmor(), profession.getId().toString());
    }

    @Override
    public List<Profession> findAll() {
        String sql = "SELECT * FROM professions";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Profession.class));
    }

    public Boolean exists(String name) {
        String sql = "SELECT * FROM professions WHERE name = ?";
        List<Profession> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Profession.class), name);
        return !result.isEmpty();
    }
}
