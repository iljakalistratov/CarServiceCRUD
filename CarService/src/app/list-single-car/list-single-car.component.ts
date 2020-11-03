import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Car } from '../car';
import { CarService } from '../car.service';

@Component({
  selector: 'app-list-single-car',
  templateUrl: './list-single-car.component.html',
  styleUrls: ['./list-single-car.component.css']
})
export class ListSingleCarComponent implements OnInit {

  car: Car;
  id: number;
  constructor(private carService: CarService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.id = params["id"];
      this.listSingleCar(this.id);
    })
  }

listSingleCar(id: number): void {
  this.carService.getCarById(id).subscribe(data => {
    this.car = data;
  });
}

updateCar(id: number) {
  this.ngOnInit();
  this.router.navigate(['update-car', id]);
}

deleteCar(id: number) {
  this.ngOnInit();
  this.carService.deleteCar(id).subscribe(data => {
    this.router.navigate(['cars']);
    console.log(data);
  },
  this.carService.getCarList
  )
}

carDetails(id: number) {
  this.router.navigate(['car-details', id]);
}


}
