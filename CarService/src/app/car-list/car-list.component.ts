import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Car } from '../car';
import { CarService } from '../car.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  cars:  Car[];

  constructor(private carService: CarService, private router: Router) { }

  ngOnInit() {
    this.carService.getCarList().subscribe(data => {
      this.cars = data;
      console.log(this.cars);
    });
  }

  updateCar(id: number) {
    this.router.navigate(['update-car', id]);
  }

  deleteCar(id: number) {
    this.carService.deleteCar(id).subscribe(data => {
      console.log(data);
      this.ngOnInit();
    },
    this.carService.getCarList
    )
  }

  carDetails(id: number) {
    this.router.navigate(['car-details', id]);
  }

}
