import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCarComponent } from './create-car.component';
import {RouterTestingModule} from "@angular/router/testing";
import {HttpClientModule} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Car} from "../car";
import {CarService} from "../car.service";

describe('CreateCarComponent', () => {
  let component: CreateCarComponent;
  let fixture: ComponentFixture<CreateCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateCarComponent ],
      imports: [ RouterTestingModule, HttpClientModule, ],
      providers: [{ provide: CarService, useClass: CarServiceStub }]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCarComponent);
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
}
