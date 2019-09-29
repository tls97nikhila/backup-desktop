import { Component, OnInit, Output , EventEmitter} from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {

  enteredText: string;
  @Output() newText1 = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }
  onEnteringText(event: string) {
    this.enteredText = event;
    console.log("Inside Component2  parent " + this.enteredText);
    this.newText1.emit(this.enteredText);
  }

}
