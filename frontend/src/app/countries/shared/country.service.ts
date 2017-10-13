import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Country } from './country';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/Rx';

@Injectable()
export class CountryService {
  // TODO: mv to API_CONFIG
  private API_URL = 'http://localhost:8080/country/';
  constructor(private http: Http) { }

  getAll() {
    return this.http.get(this.API_URL)
      .map((resp) => resp.json() as Country[]);
  }

  getAllCSV() {
    return Observable.of('text');
  }
}
