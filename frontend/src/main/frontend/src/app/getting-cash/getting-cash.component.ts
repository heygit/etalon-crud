import {Component, OnInit} from '@angular/core';

import {Hero} from "../model/hero";
import {HeroService} from "../service/hero.service";
import {Router} from "@angular/router";


@Component({
  selector: 'getting-cash',
  templateUrl: './getting-cash.component.html'
})
export class GettingCashComponent implements OnInit {

  heroes: Hero[] = [];

  constructor(private router: Router, private heroService: HeroService) {}

  ngOnInit(): void {
    this.heroService.getHeroes().then(heroes => this.heroes = heroes.slice(1, 5));
  }

  gotoDetail(hero: Hero): void {
    this.router.navigate(['/detail', hero.id]);
  }

}
