import {TestBed, inject, getTestBed} from '@angular/core/testing';

import { CountryService } from './country.service';
import {
  MockBackend
} from '@angular/http/testing';
import { MockService } from '../../shared/mock.service';
import { Country } from './country';

describe('CountryService', () => {
  let backend: MockBackend;
  let service: CountryService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: MockService.getProviders(CountryService)
    });

    const testbed = getTestBed();
    backend = testbed.get(MockBackend);
    service = testbed.get(CountryService);
  });

  it('should be created', inject([CountryService], (service: CountryService) => {
    expect(service).toBeTruthy();
  }));

  it('should return the list of countries from the backend on success', () => {
    MockService.initConnection(service['API_URL'], backend, {
      status: 200,
      body: [
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
      ]
    });

    service.getAll().subscribe((data: Country[]) => {
      expect(data.length).toBe(2);
      expect(data[0].id).toBe(1);
      expect(data[1].id).toBe(2);
      expect(data[0].name).toEqual('Country1');
      expect(data[1].name).toEqual('Country2');
      expect(data[0].shortName).toEqual('CT1');
      expect(data[1].shortName).toEqual('CT2');
    });
  });

  it('should return text data when calling fetchCSV method', () => {
    const msgBody = 'text';
    MockService.initConnection(service['API_URL'] +
      service['CSV_POSTFIX_URL'],
      backend, {
      status: 200,
      body: msgBody
    });

    service.getAllCSV().subscribe(data => {
      console.log(data);
      expect(data.ok).toBe(true);
      expect(data.text()).toEqual(msgBody);
    });
  });
});
