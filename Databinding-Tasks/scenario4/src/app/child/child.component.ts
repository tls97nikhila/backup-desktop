import { Component, OnInit ,EventEmitter,Output} from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {
  childvalue:string="im a child getting printed from parent"
@Output() outputParent=new EventEmitter<string>();
  constructor() { }

  ngOnInit() {
  }
  NotificationToParent(){
    this.outputParent.emit(this.childvalue);
  }

}
