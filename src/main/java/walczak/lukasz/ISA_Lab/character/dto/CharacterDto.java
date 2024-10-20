package walczak.lukasz.ISA_Lab.character.dto;

import lombok.Data;

@Data
public class CharacterDto implements Comparable<CharacterDto> {
    private String name;
    private int level;
    private String profession;

    public CharacterDto(String name, int level, String profession) {
        this.name = name;
        this.level = level;
        this.profession = profession;
    }

    @Override
    public int compareTo(CharacterDto other) {
        return this.name.compareTo(other.name);
    }
}