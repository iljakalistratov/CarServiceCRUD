import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Car } from '../car';
import { CarService } from '../car.service';

@Component({
  selector: 'app-create-car',
  templateUrl: './create-car.component.html',
  styleUrls: ['./create-car.component.css']
})
export class CreateCarComponent implements OnInit {

  car: Car = new Car();
  constructor(private carService: CarService, private router: Router) { }

  ngOnInit(): void {
  }

  saveCar(){
    this.ngOnInit();
    this.carService.createCar(this.car).subscribe( data => {
      console.log(data);
    },
    error => console.log(error));
    this.goToCarList();
    this.ngOnInit();
  }

  goToCarList() {
    this.router.navigate(['/cars'])
  }

  onSubmit() {
    console.log(this.car);
    this.saveCar();
  }

}
