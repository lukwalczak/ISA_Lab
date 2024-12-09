import { Component } from '@angular/core';
import {ProfessionDetails} from "../../model/profession-details";
import {ActivatedRoute, Router} from "@angular/router";
import {ProfessionService} from "../../service/profession.service";

@Component({
  selector: 'app-profession-view',
  templateUrl: './profession-view.component.html',
  styleUrls: ['./profession-view.component.css']
})
export class ProfessionViewComponent {

  profession: ProfessionDetails | undefined;

  constructor(private service: ProfessionService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getProfession(params['uuid']).subscribe(profession => {this.profession = profession;});
    })
  }
}
