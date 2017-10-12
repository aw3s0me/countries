import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountriesComponent } from './countries.component';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';

describe('CountriesComponent', () => {
  let component: CountriesComponent;
  let fixture: ComponentFixture<CountriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountriesComponent ],
      imports: [
        NgxDatatableModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
