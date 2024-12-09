import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CharacterListComponent } from "./character/view/character-list/character-list.component";
import { CharacterViewComponent } from "./character/view/character-view/character-view.component";
import { CharacterEditComponent } from "./character/view/character-edit/character-edit.component";
import {ProfessionListComponent} from "./profession/view/profession-list/profession-list.component";
import {ProfessionViewComponent} from "./profession/view/profession-view/profession-view.component";
import {CharacterCreateComponent} from "./character/view/character-create/character-create.component";
import {ProfessionCreateComponent} from "./profession/view/profession-create/profession-create.component";
import {ProfessionEditComponent} from "./profession/view/profession-edit/profession-edit.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: ProfessionEditComponent,
    path: 'professions/:uuid/edit'
  },
  {
    component: ProfessionCreateComponent,
    path: 'professions/new',
  },
  {
    component: CharacterCreateComponent,
    path: 'characters/new',
  },
  {
    component: CharacterListComponent,
    path: "characters"
  },
  {
    component: CharacterViewComponent,
    path: "characters/:uuid"
  }
  ,
  {
    component: CharacterEditComponent,
    path: "characters/:uuid/edit"
  },
  {
    component: ProfessionListComponent,
    path: "professions"
  },
  {
    component: ProfessionViewComponent,
    path: "professions/:uuid"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
