import { Routes } from '@angular/router';
import { HomeComponent } from './home';
import { NoContentComponent } from './no-content';

import { DataResolver } from './app.resolver';
import {CountriesComponent} from "./countries/countries.component";

/**
 * Created by aw3s0 on 10/12/2017.
 */
export const ROUTES: Routes = [
  { path: '',      component: HomeComponent },
  { path: 'home',  component: HomeComponent },
  { path: 'countries',  component: CountriesComponent },
  { path: '**',    component: NoContentComponent }
];
