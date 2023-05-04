import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';
@Component({
  selector: 'app-menubar',
  templateUrl: './menubar.component.html',
  styleUrls: ['./menubar.component.css']
})
export class MenubarComponent {
  
  items: MenuItem[];
  activeItem: MenuItem;
  constructor(){
    this.items= [
     
      {
        label: 'Home',
        icon: 'pi pi-home',
        styleClass: 'menuitem-hover'
      },
      {
        label:'Demande',
        icon: 'pi pi-ticket',
        styleClass: 'menuitem-hover'
      }];
      this.activeItem = this.items[0];
    }

    onActiveItemChange(event: MenuItem){
      this.activeItem = event;
  }
}
