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
import {CardNumberInputComponent} from "./card-number-input/card-number-input.component";
import {VirtualKeyboardComponent} from "./virtual-keyboard/virtual-keyboard.component";
import {PinInputComponent} from "./pin-input/pin-input.component";
import {GettingCashComponent} from "./getting-cash/getting-cash.component";
import {GettingCashResultComponent} from "./getting-cash-result/getting-cash-result.component";
import {ErrorComponent} from "./error/error.component";
import {BalanceComponent} from "./balance/balance.component";
import {OperationsComponent} from "./operations/operations.component";
import {AuthService} from "./service/auth.service";
import {HttpService} from "./service/http.service";


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    BalanceComponent,
    CardNumberInputComponent,
    ErrorComponent,
    GettingCashComponent,
    GettingCashResultComponent,
    OperationsComponent,
    PinInputComponent,
    VirtualKeyboardComponent,
    DashboardComponent,
    HeroDetailComponent,
    HeroesComponent,
    HeroSearchComponent
  ],
  providers: [
    HeroService,
    AuthService,
    HttpService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
