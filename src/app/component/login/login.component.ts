import { Component, OnInit } from '@angular/core';
import { DropdownModule } from 'primeng/dropdown';
import { CommonService } from '../../service/common.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [DropdownModule, CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  constructor(private commonService: CommonService, private router: Router) {

  }
  ngOnInit(): void {
    this.getRoles();
  }
  loginData: any = {};
  roleList: any = [];
  showPassword: boolean = false;
  toggleShowPassword() {
    this.showPassword = !this.showPassword;
  }
  getRoles() {
    this.commonService.getRequest(this.commonService.SERVER_URL['ROLE_LIST']).subscribe((response: any) => {
      if (response.status == 200) {
        this.roleList = response.result
      }
    }, (error: any) => {

    })
  }

  login() {
    this.commonService.postRequest(this.commonService.SERVER_URL['LOGIN'], this.loginData).subscribe(
      (response: any) => {
        if (response.status == 200) {
          localStorage.setItem("user", response.result);
          if(response.result && response.result.userType && response.result.userType.type=="Admin"){
            this.router.navigate(['car-list']);
          }else{
            this.router.navigate(['web-car-list']);
          }
        }
      }
    )
  }

}
