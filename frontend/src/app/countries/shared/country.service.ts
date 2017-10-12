import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Country } from './country';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';

@Injectable()
export class CountryService {
  // TODO: mv to API_CONFIG
  private API_URL = 'http://localhost:8080/countries/';
  constructor(private http: Http) { }

  getAll() {
    return this.http.get(this.API_URL)
      .map((resp) => resp.json() as Country[]);
  }
}
