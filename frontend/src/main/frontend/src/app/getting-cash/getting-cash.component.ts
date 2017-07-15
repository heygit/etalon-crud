import {Component, OnInit} from '@angular/core';

import {Router} from "@angular/router";


@Component({
  selector: 'getting-cash',
  templateUrl: './getting-cash.component.html'
})
export class GettingCashComponent implements OnInit {

  constructor(private router: Router) {}

  ngOnInit(): void {
  }

}
