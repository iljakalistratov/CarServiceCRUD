import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CarListComponent } from './car-list/car-list.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { UpdateCarComponent } from './update-car/update-car.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { SearchCarComponent } from './search-car/search-car.component';
import { ListSingleCarComponent } from './list-single-car/list-single-car.component';

const routes: Routes = [
  {path: 'cars', component: CarListComponent},
  {path: 'create-car', component: CreateCarComponent},
  {path: '', redirectTo: 'cars', pathMatch: 'full'},
  {path: 'update-car/:id', component: UpdateCarComponent},
  {path: 'car-details/:id', component: CarDetailsComponent},
  {path: 'list-single-car', component: ListSingleCarComponent}
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
