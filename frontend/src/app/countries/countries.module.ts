import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CountriesComponent } from './countries.component';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';

@NgModule({
  imports: [
    NgxDatatableModule,
    CommonModule
  ],
  declarations: [CountriesComponent]
})
export class CountriesModule { }
