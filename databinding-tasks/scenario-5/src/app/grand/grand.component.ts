import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-grand',
  templateUrl: './grand.component.html',
  styleUrls: ['./grand.component.css']
})
export class GrandComponent implements OnInit {

  textFromComponent2:string;
  constructor() { }

  ngOnInit() {
  }
  onEnteringText(event){
    this.textFromComponent2= event;
  }
}
