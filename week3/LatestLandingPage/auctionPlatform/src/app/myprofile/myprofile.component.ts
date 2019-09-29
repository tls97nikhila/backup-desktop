import { Component, OnInit } from '@angular/core';
import { AuctionService } from '../auction.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-myprofile',
  templateUrl: './myprofile.component.html',
  styleUrls: ['./myprofile.component.scss']
})
export class MyprofileComponent implements OnInit {

  constructor(private auctionService:AuctionService,private route:ActivatedRoute,
    private router:Router) { }
    email:string="mini@htrgmail.com";
    userData:any=[];
  ngOnInit() {
    this.getUserInfo(this.email);
  }
  
  getUserInfo(email):void
  {
    this.auctionService.getUserInfo(email).subscribe(data=>{
      console.log(data);
      this.userData=data;
    });
    
  }

  chunk(arr, chunkSize) {
    let R = [];
    for (let i = 0, len = arr.length; i <= len; i = i + chunkSize) {
      R.push(arr.slice(i, i + chunkSize));
    }
    return R;
  }

  
  

}
