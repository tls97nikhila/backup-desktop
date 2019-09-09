import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Lastfm } from './get-all/lastfm';
import { ITracks } from './get-all/ITracks';


@Injectable({
  providedIn: 'root'
})
export class MuzixServiceService {
  url;
  url1;
  url2="http://localhost:8082/api/v1/muzix";


  constructor(private httpclient : HttpClient) { }

  getData():Observable<Lastfm>
  {
    return this.httpclient.get<Lastfm>("http://ws.audioscrobbler.com/2.0/?method=track.search&track=%22%20+val+%22&api_key=32e5e8719e5f77dc5996a922f7707373&format=json");

  }

  getSearch(val:String):Observable<Lastfm>
  {
    this.url =  "http://ws.audioscrobbler.com/2.0/?method=track.search&track=" +val+"&api_key=32e5e8719e5f77dc5996a922f7707373&format=json";
    return this.httpclient.get<Lastfm>(this.url);

  }
}
