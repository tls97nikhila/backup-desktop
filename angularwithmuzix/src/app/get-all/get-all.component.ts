import { Component, OnInit } from '@angular/core';
import { Lastfm } from './lastfm';
import { MuzixServiceService } from '../muzix-service.service';

@Component({
  selector: 'app-get-all',
  templateUrl: './get-all.component.html',
  styleUrls: ['./get-all.component.css']
})
export class GetAllComponent implements OnInit {

  playlist:Lastfm;
  constructor(private _service:MuzixServiceService) { }

  ngOnInit() {
     this._service.getData()
 .subscribe (data=>this.playlist=data)
  }

}
