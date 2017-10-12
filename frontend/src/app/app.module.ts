import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NoContentComponent } from './no-content/no-content.component';

// ROUTES
import { ROUTES } from './app.routes';
import {
  PreloadAllModules, RouterModule
} from '@angular/router';
import { HttpModule } from '@angular/http';
import { CountriesModule } from './countries/countries.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NoContentComponent
  ],
  imports: [
    BrowserModule,
    CountriesModule,
    HttpModule,
    RouterModule.forRoot(ROUTES, { useHash: true, preloadingStrategy: PreloadAllModules }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
