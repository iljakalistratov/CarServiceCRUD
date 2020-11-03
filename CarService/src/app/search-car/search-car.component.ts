import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-car',
  templateUrl: './search-car.component.html',
  styleUrls: ['./search-car.component.css']
})
export class SearchCarComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  getID(id: number) {
    this.router.navigate(["/list-single-car"], { queryParams:{id: id}});
  }

}
