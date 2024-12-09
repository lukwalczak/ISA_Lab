import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProfessionEventService {
  private professionUpdated = new Subject<void>();

  professionUpdated$ = this.professionUpdated.asObservable();

  notifyProfessionUpdated() {
    this.professionUpdated.next();
  }
}
