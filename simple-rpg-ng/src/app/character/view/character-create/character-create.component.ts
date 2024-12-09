import {Component, OnInit} from '@angular/core';
import {CharacterForm} from "../../model/character-form";
import {Professions} from "../../../profession/model/professions";
import {CharacterService} from "../../service/character.service";
import {ProfessionService} from "../../../profession/service/profession.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Character} from "../../model/character";
import {CharacterEventService} from "../../service/character-event.service";

@Component({
  selector: 'app-character-create',
  templateUrl: './character-create.component.html',
  styleUrls: ['./character-create.component.css']
})
export class CharacterCreateComponent implements OnInit {

  character: CharacterForm ={
    name: "New Character",
    level: 1,
    professionId: "0"
  };

  professions: Professions | undefined;

  constructor(private characterService: CharacterService, private professionService: ProfessionService, private eventService: CharacterEventService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.professionService.getProfessions().subscribe(professions => {
        this.professions = professions;
        this.character.professionId = this.professions.professions[0].id;
      });
    })

  }

  /**
   * Creates character
   */
  onSubmit(): void{
    this.characterService.putCharacter(crypto.randomUUID()!, this.character!)
      .subscribe(() => {
        this.eventService.notifyCharacterUpdated();
        this.router.navigate(['/characters']);
      });
  }

}
