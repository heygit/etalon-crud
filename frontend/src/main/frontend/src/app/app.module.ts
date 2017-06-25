import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";

import {AppRoutingModule} from "./app-routing.module";

import {AppComponent} from "./app/app.component";
import {HeroesComponent} from "./heroes/heroes.component";
import {HeroDetailComponent} from "./hero_detail/hero-detail.component";
import {HeroService} from "./service/hero.service";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {HeroSearchComponent} from "./hero-search/hero-search.component";


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    DashboardComponent,
    HeroDetailComponent,
    HeroesComponent,
    HeroSearchComponent
  ],
  providers: [
    HeroService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
