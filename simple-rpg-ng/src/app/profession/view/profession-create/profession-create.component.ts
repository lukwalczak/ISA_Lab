import {Component, OnInit} from '@angular/core';
import {ProfessionForm} from "../../model/profession-form";
import {ProfessionService} from "../../service/profession.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ProfessionEventService} from "../../service/profession-event.service";

@Component({
  selector: 'app-profession-create',
  templateUrl: './profession-create.component.html',
  styleUrls: ['./profession-create.component.css']
})
export class ProfessionCreateComponent implements OnInit {

  profession: ProfessionForm = {
    name: "New profession",
    baseArmor: 1
  }


  constructor(private professionService: ProfessionService, private eventService: ProfessionEventService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
  }

  onSubmit() {
    this.professionService.createProfession(this.profession).subscribe(()=>{
      this.eventService.notifyProfessionUpdated();
    })
  }
}
