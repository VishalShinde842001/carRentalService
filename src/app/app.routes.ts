import { Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { CarlistComponent } from './component/admin/carlist/carlist.component';
import { WebCarListComponent } from './component/customer/web-car-list/web-car-list.component';

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },

    { path: 'login', component: LoginComponent },
    { path: 'car-list', component: CarlistComponent },
    { path: 'web-car-list', component: WebCarListComponent }
];
