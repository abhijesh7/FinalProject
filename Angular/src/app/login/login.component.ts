import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Model } from '../model';
import { MainService } from '../main.service';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  login=new Model();
  logins:Model[];
  message:string;
  constructor(private route:ActivatedRoute,private router:Router,private _MainService:MainService) { }

  ngOnInit() {
  }
  validLogin(form:NgForm){

    //if ((this.sessionTokenUserName==null) && (this.sessionTokenRoleId==null))
// {
 
 this._MainService.getUserId(form.value).subscribe(data=>{
   console.log(data);
   this.login=data;
   
  
    console.log(this.login);
     
     if(this.login.userId==1){
       console.log(data.username);
       this.router.navigate(['view-vendor']);
     }
       else{
       this.message="Incorrect username or password";
     }
   },
   (error) =>{
     console.log(error);
   });
   }

}
