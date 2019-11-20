import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MainService } from '../main.service';
import { Model } from '../model';

@Component({
  selector: 'app-add-vendor',
  templateUrl: './add-vendor.component.html',
  styleUrls: ['./add-vendor.component.scss']
})
export class AddVendorComponent implements OnInit {
  login=new Model();
  logins:Model[];
  constructor(private _mainService:MainService,private router:Router) { }

  ngOnInit() {
  }
  addVendor(): void{
    this._mainService.addVendorDetails(this.login)
    .subscribe((response)=>{
        console.log(response);
        this.router.navigate(['view-vendor'])
       // this._mainService.getAllDetails();
      }, (error)=>{
        console.log(error);
        
      });
      
  }
}
