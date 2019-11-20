import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NgxPaginationModule } from 'ngx-pagination';
import {FormsModule} from '@angular/forms';
import { ViewVendorComponent } from './view-vendor/view-vendor.component';
import { MainService } from './main.service';
import { AddVendorComponent } from './add-vendor/add-vendor.component';
import { EditVendorComponent } from './edit-vendor/edit-vendor.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ViewVendorComponent,
    AddVendorComponent,
    EditVendorComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    NgxPaginationModule
    
  ],
  providers: [MainService],
  bootstrap: [AppComponent]
})
export class AppModule { }
