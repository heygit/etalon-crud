import {Component, OnInit} from '@angular/core';

import {Hero} from "../model/hero";
import {Router} from "@angular/router";
import {AuthService} from "../service/auth.service";


@Component({
  selector: 'card-number-input',
  templateUrl: './card-number-input.component.html'
})
export class CardNumberInputComponent implements OnInit {

  cardNumber: string = "";

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
  }

  gotoDetail(hero: Hero): void {
    this.router.navigate(['/detail', hero.id]);
  }

  onClick(number: Number): void {
    this.cardNumber+= String(number);
  }

  clear(): void {
    this.cardNumber = "";
  }

  submit(): void {
    this.authService.checkCard(this.cardNumber)
      .then((status) => {
        if (status == 'ok') {
          this.router.navigate(['/input-pin']);
        }
      })
      .catch(() => {
        this.router.navigate(['/error']);
      });
  }

}
