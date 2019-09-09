import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { SearchComponentComponent } from './search-component/search-component.component';
const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/home-page' },
  { path: 'home-page', component: HomePageComponent },
  { path: 'result/:name', component: SearchComponentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
