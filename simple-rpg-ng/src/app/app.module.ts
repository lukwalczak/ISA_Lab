import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { HttpClientModule } from "@angular/common/http";
import { CharacterListComponent } from './character/view/character-list/character-list.component';
import { CharacterService } from './character/service/character.service';
import { CharacterViewComponent } from './character/view/character-view/character-view.component';
import { CharacterEditComponent } from './character/view/character-edit/character-edit.component';
import { FormsModule } from "@angular/forms";
import { ProfessionListComponent } from './profession/view/profession-list/profession-list.component';
import {ProfessionService} from "./profession/service/profession.service";
import { ProfessionViewComponent } from './profession/view/profession-view/profession-view.component';
import { CharacterCreateComponent } from './character/view/character-create/character-create.component';
import { ProfessionCreateComponent } from './profession/view/profession-create/profession-create.component';
import { ProfessionEditComponent } from './profession/view/profession-edit/profession-edit.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoggingInterceptor } from './logging.interceptor';

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    CharacterListComponent,
    CharacterViewComponent,
    CharacterEditComponent,
    ProfessionListComponent,
    ProfessionViewComponent,
    CharacterCreateComponent,
    ProfessionCreateComponent,
    ProfessionEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    CharacterService,
    ProfessionService,
    { provide: HTTP_INTERCEPTORS, useClass: LoggingInterceptor, multi: true }
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
