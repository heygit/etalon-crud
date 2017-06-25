import {Component, EventEmitter, OnInit, Output} from "@angular/core";
import {HeroService} from "../service/hero.service";
import {Router} from "@angular/router";


@Component({
  selector: 'virtual-keyboard',
  templateUrl: './virtual-keyboard.component.html'
})
export class VirtualKeyboardComponent implements OnInit {

  @Output()
  private clickEmitter = new EventEmitter<Number>();

  constructor(private router: Router, private heroService: HeroService) {}

  ngOnInit(): void {
  }

  click(number: Number): void {
    this.clickEmitter.emit(number);
  }

}
