import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent implements OnInit {
  rows = [
    { id: 1, name: 'Country1', shortName: 'CT1' },
    { id: 2, name: 'Country2', shortName: 'CT2' },
    { id: 3, name: 'Country3', shortName: 'CT3' },
  ];
  columns = [
    { name: 'ID' },
    { name: 'Name' },
    { name: 'Short Name' }
  ];

  constructor() { }

  ngOnInit() {
  }

}
