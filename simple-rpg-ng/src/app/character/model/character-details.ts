import { Profession } from "../../profession/model/profession";

/**
 * Represents single character in list.
 */
export interface CharacterDetails {

  /**
   * Unique id identifying character.
   */
  id: string;

  /**
   * Name of the character.
   */
  name: string;

  /**
   * Character's level.
   */
  level: number;

  /**
   * Character's profession.
   */
  profession: Profession;

}
