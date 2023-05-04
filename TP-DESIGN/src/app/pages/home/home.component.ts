import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private router: Router){

  }

  // Fonction de redirection vers la page de connexion
  login(){
    this.router.navigate(['/connexion'])
  }

  // Fonction de redirection vers la page d'enregistrement
  register(){
    this.router.navigate(['/enregistrement'])
  }


}
