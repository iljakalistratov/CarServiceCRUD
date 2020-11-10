import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from './car';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseURL = "http://minikube:30002/carlist";
  private postURL = "http://minikube:30002/car";

  constructor(private http: HttpClient) { }

  getCarList(): Observable<Car[]> {
    return this.http.get<Car[]>(this.baseURL);
  }

  createCar(car: Car): Observable<Object> {
    return this.http.post(`${this.postURL}`, car);
  }

  getCarById(id: number):Observable<Car>{
    return this.http.get<Car>(`${this.postURL}/${id}`)
  }

  updateCar(id: number, car: Car): Observable<Object>{
    return this.http.put(`${this.postURL}/${id}`, car)
  }

  deleteCar(id: number): Observable<Object> {
    return this.http.delete(`${this.postURL}/${id}`);
  }

}
