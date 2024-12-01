import { Component, OnInit } from '@angular/core';
import { SideBarComponent } from '../side-bar/side-bar.component';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-carlist',
  standalone: true,
  imports: [SideBarComponent, CommonModule],
  templateUrl: './carlist.component.html',
  styleUrl: './carlist.component.css'
})
export class CarlistComponent implements OnInit {
  ngOnInit(): void {
    this.getCarList();
  }

  carList: any = [];
  getCarList() {

  }

}
