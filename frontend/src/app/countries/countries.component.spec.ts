import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import { CountriesComponent } from './countries.component';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { MockService } from '../shared/mock.service';
import { CountryService } from './shared/country.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';

describe('CountriesComponent', () => {
  let component: CountriesComponent;
  let fixture: ComponentFixture<CountriesComponent>;
  let service: CountryService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountriesComponent ],
      imports: [
        NgxDatatableModule
      ],
      providers: MockService.getProviders(CountryService)
    }).compileComponents()
      .then(() => {
        fixture = TestBed.createComponent(CountriesComponent);
        component = fixture.componentInstance;

        service = fixture.debugElement.injector.get(CountryService);
      });
  }));

  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it('should assign data when route is resolved', (done) => {
    fixture.whenStable().then(() => {
      const spy = spyOn(service, 'getAll').and.returnValue(
        Observable.of([
          {
            id: 1,
            name: 'Country1',
            shortName: 'CT1'
          },
          {
            id: 2,
            name: 'Country2',
            shortName: 'CT2'
          }
        ])
      );

      expect(component.rows.length).toBe(0);
      component.ngOnInit();
      // set router
      fixture.detectChanges();
      expect(spy.calls.any()).toBe(true);
      expect(component.rows.length).toBe(2);
      done();
    })
  });
});
