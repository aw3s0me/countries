import { Component, OnInit } from '@angular/core';
import { CountryService } from './shared/country.service';
import * as FileSaver from 'file-saver';

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
  CSV_FILENAME = 'countries.csv';

  constructor(private service: CountryService) { }

  ngOnInit() {
    this.service.getAll()
      .subscribe((data) => this.rows = data);
  }

  onCSVFetchButtonClick() {
    this.service.getAllCSV().subscribe((csv) => {
        const blob = new Blob([csv], { type: 'text/csv' });
        FileSaver.saveAs(blob, this.CSV_FILENAME)
      });
  }
}
