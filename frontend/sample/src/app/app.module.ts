import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ModalModule} from './modal/modal.module';
import { NavbarComponent } from './navbar/navbar.component';
import { SearchComponentComponent } from './search-component/search-component.component';
import { HomePageComponent } from './home-page/home-page.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SearchComponentComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ModalModule
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
 
