import { Component, OnInit } from '@angular/core';
import { CharacterService } from "../../service/character.service";
import { Characters } from "../../model/characters";
import { Character } from "../../model/character";
import { CharacterEventService } from "../../service/character-event.service";

@Component({
  selector: 'app-character-list',
  templateUrl: './character-list.component.html',
  styleUrls: ['./character-list.component.css']
})
export class CharacterListComponent implements OnInit{

  /**
   * @param service characters service
   * @param eventService
   */
  constructor(private service: CharacterService, private eventService: CharacterEventService) {
  }

  /**
   * Available characters.
   */
  characters: Characters | undefined;

  ngOnInit(): void {
    this.fetchCharacters();

    this.eventService.characterUpdated$.subscribe(()=>{
      this.fetchCharacters();
    })
  }

  fetchCharacters(): void {
    this.service.getCharacters().subscribe(characters => this.characters = characters);
  }

  onDelete(character: Character): void {
    this.service.deleteCharacter(character.id).subscribe(() => {
      this.ngOnInit();
      this.eventService.notifyCharacterUpdated();
    });
  }


}
