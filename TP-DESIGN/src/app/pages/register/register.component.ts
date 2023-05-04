import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  value!: string;
  value2!: string;
  value3!: string;
  value4!: string;
  value5!: string;
  enregistrement!:any;

  constructor(private router:Router, private api: ApiService){}
 

  // Fonction de redirection vers la page de connexion
  login(){
    this.router.navigate(['/connexion'])
  }

  // Enregistrement des données

  Enregistrement(){
    if (this.value4 == this.value5){
      this.enregistrement = {
        "nom":this.value,
        "prenom":this.value2,
        "email":this.value3,
        "password":this.value4
  
      }
      console.log(this.enregistrement)
      this.api.createUser(this.enregistrement).subscribe({
        next: (response: any) => {
          console.log(response)
          alert(`Enregistrement effectué avec succès`);
          this.router.navigate(['/connexion'])
        },
        error: (error: any) => {
          console.log(error);
          alert(`Echec d'enregistrement`);
        },
      });

    }else{
      alert("les mots de passe ne sont pas indentiquent")
    }

  }
 
}
