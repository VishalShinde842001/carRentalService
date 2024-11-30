import { Component } from '@angular/core';
import { SideBarComponent } from '../side-bar/side-bar.component';

@Component({
  selector: 'app-carlist',
  standalone: true,
  imports: [SideBarComponent],
  templateUrl: './carlist.component.html',
  styleUrl: './carlist.component.css'
})
export class CarlistComponent {

}
