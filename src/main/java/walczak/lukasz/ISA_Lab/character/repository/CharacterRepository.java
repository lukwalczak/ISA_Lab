package walczak.lukasz.ISA_Lab.character.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import walczak.lukasz.ISA_Lab.character.entity.Character;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CharacterRepository implements CrudRepository<Character, UUID> {

        private final JdbcTemplate jdbcTemplate;

        @Autowired
        public CharacterRepository(JdbcTemplate jdbcTemplate) {
                this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        public Optional<Character> findByID(UUID id) {
                String sql = "SELECT * FROM character WHERE id = ?";
                List<Character> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Character.class), id.toString());

                return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
        }

        @Override
        public void save(Character character) {
                String sql = "INSERT INTO character (id, name, level, profession_id) VALUES (?, ?, ?, ?)";
                jdbcTemplate.update(sql, character.getId().toString(), character.getName(), character.getLevel(), character.getProfession().getId().toString());
        }

        @Override
        public void delete(Character character) {
                String sql = "DELETE FROM character WHERE id = ?";
                jdbcTemplate.update(sql, character.getId().toString());
        }

        @Override
        public void deleteByID(UUID id) {
                String sql = "DELETE FROM character WHERE id = ?";
                jdbcTemplate.update(sql, id.toString());
        }

        @Override
        public void update(Character character) {
                String sql = "UPDATE character SET name = ?, level = ?, profession_id = ? WHERE id = ?";
                jdbcTemplate.update(sql, character.getName(), character.getLevel(), character.getProfession().getId().toString(), character.getId().toString());
        }

        @Override
        public List<Character> findAll() {
                String sql = "SELECT * FROM character";
                return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Character.class));
        }
}
