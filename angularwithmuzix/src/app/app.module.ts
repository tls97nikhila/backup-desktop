import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MuzixMaterialModule } from './muzix-material/muzix-material.module';
import { SearchComponent } from './search/search.component';
import { GetAllComponent } from './get-all/get-all.component';
import { MuzixServiceService } from './muzix-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    GetAllComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MuzixMaterialModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [MuzixServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
