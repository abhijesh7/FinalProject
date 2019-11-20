import { Component, OnInit } from '@angular/core';
import { Model } from '../model';
import { Router } from '@angular/router';
import { MainService } from '../main.service';

@Component({
  selector: 'app-view-vendor',
  templateUrl: './view-vendor.component.html',
  styleUrls: ['./view-vendor.component.scss']
})
export class ViewVendorComponent implements OnInit {
  vendors: Model[];
  vendor = new Model();
  constructor(private _MainService:MainService, private router:Router) { }

  ngOnInit() {
    this.getVendors();
  }
  edit(vId:number):void{
    console.log(vId);
    this.router.navigate(['editvendor/'+vId]);
  }
  getVendors(): void {
    this._MainService.getAllDetails().subscribe((data) => { this.vendors = data, console.log(data); }, (error) => { console.log(error); });
  }
  

  //Disable vendor
  disableVendor(vId:number):void{
      
    this._MainService.disableVendor(vId)
    .subscribe((data)=>{
      this.getVendors();
      console.log(data)
    }, (error)=>{
      console.log(error)
    
    
    });
      
   }

   //sort By Id
   sortById():void{
      
    this._MainService.sortById()
    .subscribe((data)=>{
      this.getVendors();
      this.router.navigate(['view-vendor']);
      console.log(data)
    }, (error)=>{
      console.log(error)
    
    
    });
      
   }

   sortByName():void{
      
    this._MainService.sortByName()
    .subscribe((data)=>{
      this.getVendors();
      this.router.navigate(['view-vendor']);
      console.log(data)
    }, (error)=>{
      console.log(error)
    
    
    });
      
   }



   //Logout
   logout(vId:number){
    this.router.navigate(['login']);
   }

   //Add vendor
   addVendor()
   {
    this.router.navigate(['addvendor']);
   }

   searchVendor(search:string):void{
      
    this._MainService.searchVendor(search)
    .subscribe((data)=>{
      this.vendors=data;
      console.log(data)
    }, (error)=>{
      console.log(error)
    
    
    });
      
   }

}
