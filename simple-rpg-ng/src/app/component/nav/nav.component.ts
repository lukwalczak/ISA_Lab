import { Component } from '@angular/core';
import {Professions} from "../../profession/model/professions";
import {Characters} from "../../character/model/characters";
import {CharacterService} from "../../character/service/character.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ProfessionService} from "../../profession/service/profession.service";
import {CharacterEventService} from "../../character/service/character-event.service";
import {ProfessionEventService} from "../../profession/service/profession-event.service";

/**
 * Represents main navigation.
 */
@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  professions: Professions | undefined;
  characters: Characters | undefined;

  constructor(private characterService: CharacterService, private professionService: ProfessionService, private characterEventService: CharacterEventService, private professionEventService: ProfessionEventService  , private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.fetchCharacters();
    this.fetchProfessions();
    this.professionEventService.professionUpdated$.subscribe(profession => {
      this.fetchProfessions();
    })
    this.characterEventService.characterUpdated$.subscribe(()=>{
      this.fetchCharacters();
    })
  }

  fetchProfessions(): void {
    this.professionService.getProfessions().subscribe(professions => this.professions = professions);
  }

  fetchCharacters(): void {
    this.characterService.getCharacters().subscribe(characters => this.characters = characters);
  }

}
