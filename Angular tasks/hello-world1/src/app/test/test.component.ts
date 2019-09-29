import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  template:`<div>
              Welcome {{name}}
             </div>
             <h2>{{2+2}}</h2>
             <h2>{{name.length}}</h2>
             <h3>{{greetUser()}}</h3>
             <h2>{{siteUrl}}</h2>
             <input  [id]="myId" type="text" value="reminder">
             <input disabled id={{myId}} type="text" value="interpolation">
             <input [disabled]="false" id={{myId}} type="text" value="disabled using hard coding">
             <input [disabled]="isDisabled" id={{myId}} type="text" value="using braces">
             <input bind-disabled="isDisabled" id={{myId}} type="text" value="bind-property">
              <h3 [class]="successClass">Revolution</h3> 
              <h3 [class.text-danger]="isError"> is Error in Revolution</h3> 
              <h4 [ngClass] = "messageClasses" >Lock the Answer</h4>
      `,
  styles: [`
   .text-success {
     color: green;
   }
   .text-danger {
     color: red;
   }
   .text-special {
     font-style: italic;
   }
  `]
})
export class TestComponent implements OnInit {

  public name="Talla";
  public myId="testdata";
  public isDisabled=false;
  public siteUrl=window.location.href;


  public successClass="text-success";
  public isError = true;
  public isSpecial= true;
  public messageClasses = {
    "text-success": !this.isError,
    "text-danger" : this.isError,
    "text-special" : this.isSpecial
  }
  constructor() { }

  ngOnInit() {
  }
  greetUser(){
    return "hai" + this.name;
  }
}
