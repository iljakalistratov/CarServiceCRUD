import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppComponent } from './app.component';
import { CarListComponent } from './car-list/car-list.component';
import { AppRoutingModule } from './app-routing.module';
import { CreateCarComponent } from './create-car/create-car.component';
import { FormsModule} from '@angular/forms';
import { UpdateCarComponent } from './update-car/update-car.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { SearchCarComponent } from './search-car/search-car.component';
import { ListSingleCarComponent } from './list-single-car/list-single-car.component';

@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    CreateCarComponent,
    UpdateCarComponent,
    CarDetailsComponent,
    SearchCarComponent,
    ListSingleCarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
