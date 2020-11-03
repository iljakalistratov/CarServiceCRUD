import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSingleCarComponent } from './list-single-car.component';

describe('ListSingleCarComponent', () => {
  let component: ListSingleCarComponent;
  let fixture: ComponentFixture<ListSingleCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListSingleCarComponent ]
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
