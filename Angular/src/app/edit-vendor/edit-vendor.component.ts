import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MainService } from '../main.service';
import { Model } from '../model';

@Component({
  selector: 'app-edit-vendor',
  templateUrl: './edit-vendor.component.html',
  styleUrls: ['./edit-vendor.component.scss']
})
export class EditVendorComponent implements OnInit {
  login=new Model();
  logins:Model[];
  constructor(private route:ActivatedRoute,private _router:Router,private _mainService:MainService) { }

  ngOnInit() {
    this.route.params.subscribe(params => this.getVendorById(params['vId']));
  }
  getVendorById(vId:number){
    console.log("vId"+vId);
    this._mainService.getVendorById(vId)
    .subscribe((searchData) =>{
      this.logins=searchData;
      console.log(searchData);
    }, (error) =>{
    console.log(error);
  });
    }
  
    updateVendor():void{
      this._mainService.updateVendorDetails(this.login)
      .subscribe((response) => {
        console.log(response);
        this._router.navigate(['view-vendor']);
      }, (error) =>{
        console.log(error);
      });
      
    }
}
