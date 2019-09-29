import { Component, OnInit,Output,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  text:string;
  @Output() newText = new EventEmitter<string>();
  constructor() { }

  ngOnInit() {
  }
  onSubmit(){
    console.log("Inside component3 child "+ this.text);
    this.newText.emit(this.text);
  }

}
