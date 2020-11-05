import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchCarComponent } from './search-car.component';
import {ActivatedRoute, RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {RouterTestingModule} from "@angular/router/testing";
import {Observable, of} from "rxjs";
import {Car} from "../car";
import {CarService} from "../car.service";

describe('SearchCarComponent', () => {
  let component: SearchCarComponent;
  let fixture: ComponentFixture<SearchCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchCarComponent ],
      imports: [ RouterModule, RouterTestingModule, HttpClientModule ],
      providers: [{ provide: CarService, useClass: CarServiceStub }]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

class CarServiceStub {
  createCar(car: any): Observable<any> {
    return of(Car);
  }

  getCarById(number: any): Observable<Car> {
    return new Observable<Car>();
  }

}
