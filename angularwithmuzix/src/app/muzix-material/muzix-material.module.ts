import { NgModule } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import { NgxMatSelectSearchModule } from 'ngx-mat-select-search';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import { NgMatSearchBarModule } from 'ng-mat-search-bar';




const material =[MatToolbarModule,NgMatSearchBarModule,NgxMatSelectSearchModule,MatSelectModule,MatFormFieldModule];

@NgModule({
  imports: [
    material
  ],
  exports:[
    material
  ]
})
export class MuzixMaterialModule { }
