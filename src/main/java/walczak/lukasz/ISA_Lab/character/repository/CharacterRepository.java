package walczak.lukasz.ISA_Lab.character.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import walczak.lukasz.ISA_Lab.character.entity.Character;
import walczak.lukasz.ISA_Lab.character.entity.Profession;

import java.sql.ResultSet;
import java.sql.SQLException;
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
                String sql = "SELECT * FROM characters WHERE id = ?";
                List<Character> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Character.class), id.toString());

                return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
        }

        @Override
        public void save(Character character) {
                String sql = "INSERT INTO characters (id, name, level, profession_id) VALUES (?, ?, ?, ?)";
                if (character.getProfession() != null) {
                        System.out.println("Saving character with profession: " + character.getProfession().getId().toString());
                        jdbcTemplate.update(sql, character.getId().toString(), character.getName(), character.getLevel(), character.getProfession().getId().toString());
                } else {
                        throw new IllegalArgumentException("Profession cannot be null");
                }
        }


        @Override
        public void delete(Character character) {
                String sql = "DELETE FROM characters WHERE id = ?";
                jdbcTemplate.update(sql, character.getId().toString());
        }

        @Override
        public void deleteByID(UUID id) {
                String sql = "DELETE FROM characters WHERE id = ?";
                jdbcTemplate.update(sql, id.toString());
        }

        @Override
        public void update(Character character) {
                String sql = "UPDATE characters SET name = ?, level = ?, profession_id = ? WHERE id = ?";
                jdbcTemplate.update(sql, character.getName(), character.getLevel(), character.getProfession().getId().toString(), character.getId().toString());
        }

        public class CharacterRowMapper implements RowMapper<Character> {
                @Override
                public Character mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Character character = new Character();
                        character.setId(UUID.fromString(rs.getString("characters.id")));
                        character.setName(rs.getString("characters.name"));
                        character.setLevel(rs.getInt("characters.level"));

                        Profession profession = new Profession();
                        profession.setId(UUID.fromString(rs.getString("professions.id")));
                        profession.setName(rs.getString("professions.name"));
                        profession.setBaseArmor(rs.getInt("professions.baseArmor"));

                        character.setProfession(profession);

                        return character;
                }
        }

        @Override
        public List<Character> findAll() {
                String sql = "SELECT characters.*," +
                        " professions.* " +
                        "FROM characters INNER JOIN professions ON characters.profession_id = professions.id";
                return jdbcTemplate.query(sql, new CharacterRowMapper());
        }


}
