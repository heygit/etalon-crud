import {Component, OnInit} from "@angular/core";

import {Router} from "@angular/router";


@Component({
  selector: 'getting-cash-result',
  templateUrl: './getting-cash-result.component.html'
})
export class GettingCashResultComponent implements OnInit {

  constructor(private router: Router) {}

  ngOnInit(): void {
  }

}
