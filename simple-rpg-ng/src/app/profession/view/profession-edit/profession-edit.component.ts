import {Component, OnInit} from '@angular/core';
import {ProfessionForm} from "../../model/profession-form";
import {ProfessionService} from "../../service/profession.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-profession-edit',
  templateUrl: './profession-edit.component.html',
  styleUrls: ['./profession-edit.component.css']
})
export class ProfessionEditComponent implements OnInit{

  uuid: string | undefined;

  profession: ProfessionForm | undefined;

  original: ProfessionForm | undefined;

  constructor(private professionService: ProfessionService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.professionService.getProfession(params['uuid'])
        .subscribe(profession => {
          this.uuid = profession.id;
          this.profession = {
            name: profession.name,
            baseArmor: profession.baseArmor
          }
          this.original = {...this.profession};
      })
    })
  }

  onSubmit(): void {
    this.professionService.putProfession(this.uuid!, this.profession!).subscribe(()=>{
      this.router.navigate(['/professions']);
    })
  }

}
