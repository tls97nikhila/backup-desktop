import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  template:`
          <h2> Welcome {{name}} </h2>
          <h2 [style.color]="hasError ? 'red' : 'pink'"> Style Binding </h2>
          <h2> Sample please </h2>
  `,
  styles: []
})
export class TestComponent implements OnInit {

  public name = "Sarkarrrrr";
  public hasError = true;
  public isSpecial = true;
  constructor() { }

  ngOnInit() {
  }

}
