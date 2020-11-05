import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCarComponent } from './update-car.component';
import {RouterTestingModule} from "@angular/router/testing";
import {HttpClientModule} from "@angular/common/http";
import {CarService} from "../car.service";
import {Observable, of} from "rxjs";
import {Car} from "../car";

describe('UpdateCarComponent', () => {
  let component: UpdateCarComponent;
  let fixture: ComponentFixture<UpdateCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateCarComponent ],
      imports: [ RouterTestingModule, HttpClientModule ],
      providers: [{ provide: CarService, useClass: CarServiceStub }]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

class CarServiceStub {
  updateCar(id: number, car: Car): Observable<any> {
    return new Observable<Car>();
  }

  getCarById(id: number): Observable<Car> {
    return new Observable<Car>();
  }

}
