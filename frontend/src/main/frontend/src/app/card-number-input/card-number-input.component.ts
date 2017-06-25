import {Component, OnInit} from '@angular/core';

import {Hero} from "../model/hero";
import {HeroService} from "../service/hero.service";
import {Router} from "@angular/router";


@Component({
  selector: 'card-number-input',
  templateUrl: './card-number-input.component.html',
  styleUrls: ['./card-number-input.component.css']
})
export class CcardNumberInputComponent implements OnInit {

  cardNumber: String = "";

  constructor(private router: Router, private heroService: HeroService) {}

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
    //httpservice send request!!!
  }

}
