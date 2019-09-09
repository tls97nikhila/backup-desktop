import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class MuzixService {
  value:string = "";
  constructor(private http:HttpClient) { }



  getTrendMuzix():any{
    return this.http.get("http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=ecc55a848a37fd1724dcf80907395b33&format=json");
  }

  getMuzix(value){
    this.value =value;
    var url=`http://ws.audioscrobbler.com/2.0/?method=track.search&track=${value}&api_key=ecc55a848a37fd1724dcf80907395b33&format=json`;
    return this.http.get(url);
  }
  

}
