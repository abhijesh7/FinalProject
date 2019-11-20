import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ViewVendorComponent } from './view-vendor/view-vendor.component';
import { AddVendorComponent } from './add-vendor/add-vendor.component';
import { EditVendorComponent } from './edit-vendor/edit-vendor.component';


const routes: Routes = [
  {path:'',component: LoginComponent},
  {path:'login',component:LoginComponent},
  {path:'view-vendor',component:ViewVendorComponent},
  {path:'addvendor',component:AddVendorComponent},
  {path:'editvendor/:vId',component:EditVendorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
