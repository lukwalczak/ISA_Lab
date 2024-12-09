import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import {ProfessionEventService} from "../../profession/service/profession-event.service";

@Injectable({
  providedIn: 'root',
})
export class CharacterEventService{

  private characterUpdated = new Subject<void>();

  constructor(private professionEventService: ProfessionEventService) {
    this.professionEventService.professionUpdated$.subscribe(()=>{
      this.characterUpdated.next();
    })
  }

  characterUpdated$ = this.characterUpdated.asObservable();

  notifyCharacterUpdated() {
    this.characterUpdated.next();
  }
}
