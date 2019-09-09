import { Component, OnInit } from '@angular/core';
import { MuzixService } from '../muzix.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private muzixService:MuzixService, private route: ActivatedRoute,
    private router:Router) { }
  arrayOfMuzix:any=[];
  ngOnInit() {
      this.muzixService.getTrendMuzix().subscribe(data=>
        {
            console.log(data.tracks.track);
            this.arrayOfMuzix=data.tracks.track;
        });

  }


  
  
  click(value){
   
    this.router.navigateByUrl("/result/"+value);
  
  }
 

}
