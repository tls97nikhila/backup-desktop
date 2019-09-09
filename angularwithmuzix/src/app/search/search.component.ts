import { Component, OnInit } from '@angular/core';
import { MuzixServiceService } from '../muzix-service.service';
import { HttpClient } from '@angular/common/http';
import { FormControl } from '@angular/forms';
import { Lastfm } from '../get-all/lastfm';
import { ITracks } from '../get-all/ITracks';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  muzix:string; 
  searchData; 
  playList:Lastfm;
  constructor(private _searchService: MuzixServiceService,private http:HttpClient ) { }
  

  ngOnInit() {
    
  }

  search(value)
  {
    //this.muzix = value;
    this._searchService.getSearch(value).subscribe((data)=>
    {
      this.playList = data;//['results']['trackmatches']['track'];
    });
  }
}
