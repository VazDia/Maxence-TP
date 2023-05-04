import { jsDocComment } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/services/api.service';
import { UserValidatorService } from 'src/app/services/user-validator.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  /*user!:FormGroup;
  connexion!:any; */

  value!:string;
  value2!:string;

  connexion!:any;

  constructor(private api: ApiService,private router:Router){
    
    
  }

  // Methode de connexion
  Connexion(){
    this.connexion = {"email":this.value, "password":this.value2};
    /*this.connexion = JSON.stringify(this.connexion);*/
    this.api.userLogin(this.connexion).subscribe({
      next: (response: any) => {
        console.log(response)
        alert(`Connexion reussie`);
        this.router.navigate(['/'])
      },
      error: (error: any) => {
        console.log(error);
        alert(`Connexion echouée`);
      },
    });

  }



   // Fonction de redirection vers la page d'enregistrement
   register(){
    this.router.navigate(['/enregistrement'])
  }
}
  

  
 

