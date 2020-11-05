import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSingleCarComponent } from './list-single-car.component';
import {RouterTestingModule} from "@angular/router/testing";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {Observable, of} from "rxjs";
import {Car} from "../car";
import {CarService} from "../car.service";

describe('ListSingleCarComponent', () => {
  let component: ListSingleCarComponent;
  let fixture: ComponentFixture<ListSingleCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListSingleCarComponent ],
      imports: [ HttpClientModule, RouterTestingModule ],
      providers: [{ provide: CarService, useClass: CarServiceStub }]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSingleCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

class CarServiceStub {
  getCarById(number: any): Observable<Car> {
    return new Observable<Car>();
  }
}
