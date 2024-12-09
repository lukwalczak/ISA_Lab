import {Component} from '@angular/core';
import {ProfessionService} from "../../service/profession.service";
import {Professions} from '../../model/professions';
import {Profession} from "../../model/profession";
import {ProfessionEventService} from "../../service/profession-event.service";

@Component({
  selector: 'app-profession-list',
  templateUrl: './profession-list.component.html',
  styleUrls: ['./profession-list.component.css']
})
export class ProfessionListComponent {


  constructor(private service: ProfessionService, private eventService: ProfessionEventService) {
  }

  professions: Professions | undefined;

  ngOnInit() {
    this.service.getProfessions().subscribe(professions => {
      this.fetchProfessions();
    });
    this.eventService.professionUpdated$.subscribe(profession => {
      this.fetchProfessions();
    })
  }

  fetchProfessions(): void {
    this.service.getProfessions().subscribe(professions => { this.professions = professions; });
  }

  onDelete(profession: Profession): void {
    this.service.deleteProfession(profession.id).subscribe(()=>{
      this.ngOnInit();
      this.eventService.notifyProfessionUpdated();
    })
  }
}
