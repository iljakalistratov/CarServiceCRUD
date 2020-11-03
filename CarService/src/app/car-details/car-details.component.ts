import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Car } from '../car';
import { CarService } from '../car.service';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  id: number
  car: Car
  constructor(private route: ActivatedRoute, private carService: CarService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.car = new Car();
    this.carService.getCarById(this.id).subscribe(data => {
      this.car = data;
    })
  }

}
