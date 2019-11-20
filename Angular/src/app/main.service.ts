import { Injectable } from '@angular/core';
import { Model } from './model';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class MainService {
  
  constructor(private _httpService:HttpClient,private _router:Router) { }

  //LOgin
  getUserId(formData:any):any{
    return this._httpService.get<Model>(environment.APIUrl+'api/login/'+formData.username+'/'+formData.password);
  }
 //View vendor details
 getAllDetails(): Observable<Model[]>{
  return this._httpService.get<Model[]>(environment.APIUrl +'/api/vendordetails');
}
 //Add vendor details
 addVendorDetails(model:Model)
  {
    let body = JSON.stringify(model);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers } 

    console.log(model.vId);
      return this._httpService.post(environment.APIUrl +'api/vendor/add',body,options);
  }

  //Update
  updateVendorDetails(model:Model)
  {
    let body = JSON.stringify(model);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    return this._httpService.put(environment.APIUrl +'api/vendor/update',body,options);  
  }
 //Disable vendor
  disableVendor(vId:number): Observable<Model>{
    let body = JSON.stringify(vId);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
    return this._httpService.put<Model>(environment.APIUrl +'api/disablevendor/'+ vId,body,options);
  }
  //Sort by vId
  sortById(): Observable<Model[]>{
    return this._httpService.get<Model[]>(environment.APIUrl +'/api/vendor/sortbyid');
  }

  ////Sort by vName
  sortByName(): Observable<Model[]>{
    return this._httpService.get<Model[]>(environment.APIUrl +'/api/vendor/sortbyid');
  }
  //search by Id
  getVendorById(vId:number): Observable<Model[]>{
    return this._httpService.get<Model[]>(environment.APIUrl +'/api/getVenderByid/'+vId);
  }

  searchVendor(search:string): Observable<Model[]>{
    return this._httpService.get<Model[]>(environment.APIUrl +'/api/vendor/'+search);
  }

}
