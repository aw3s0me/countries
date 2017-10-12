import { Component, OnInit } from '@angular/core';
import { CountryService } from './shared/country.service';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css'],
  providers: [
    CountryService
  ]
})
export class CountriesComponent implements OnInit {
  rows = [];
  columns = [
    { name: 'ID' },
    { name: 'Name' },
    { name: 'Short Name' }
  ];

  constructor(private service: CountryService) { }

  ngOnInit() {
    this.service.getAll()
      .subscribe((data) => this.rows = data);
  }
}
