import {Component, OnInit} from '@angular/core';

import {Hero} from "../model/hero";
import {HeroService} from "../service/hero.service";
import {ActivatedRoute, Params, Router} from "@angular/router";


@Component({
  selector: 'error',
  templateUrl: './error.component.html'
})
export class ErrorComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router) {}

  message: String = '';

  ngOnInit(): void {
    this.route.params
      .subscribe((params: Params) => {
        if (params['code'] != null) {
          this.message = params['code'];
        } else {
          this.message = 'Something went wrong';
        }
      })
  }

  return() {
    this.router.navigate(['/']);
  }

}
