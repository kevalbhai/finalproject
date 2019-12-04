import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user_name: Array<string>;
  dummy: string;
  loginForm: FormGroup
  constructor(private formBuild: FormBuilder, private authService: AuthenticationService, private router: Router) { } //Remember authservice was AuthServiceService
  ngOnInit() {
    this.loginForm = this.formBuild.group({
      username: ['', [
        Validators.required
      ]],
      password: ['', [
        Validators.required
      ]]
    })
  }
  get username() {
    return this.loginForm.get('username');
  }
  get password() {
    return this.loginForm.get('password');
  }
  getUsername() {
    return this.loginForm.value['username'];
  }
  getUser_name(){
     this.dummy = this.loginForm.value['username'];
     this.user_name = this.dummy.split("@",2);
     console.log(this.user_name[0]);
     return this.user_name[0];
  }
  getPassword() {
    return this.loginForm.value['password'];
  }
  toSignup() {
    this.router.navigate(['signup'])
  }
  invalidLogin: boolean;
  error: string = "Login Failed"
  onSubmit() {
    this.authService.authenticate(this.getUsername(), this.getPassword()).subscribe(
      data => {
        this.authService.setToken(data.token);
        this.error = "Logged In successfully";
        this.authService.username = this.getUser_name();
        this.authService.loggedIn = true;
        this.authService.loggedIn = true;
        this.authService.validCredentials = true;
        this.authService.setUserId();
        console.log(data.role);
        //if (data.role == "admin")
         // this.foodService.isAdmin = true;
       // else
          //this.foodService.isAdmin = false;
        this.router.navigate(['/search-bar'])
       },
      error => {
        this.authService.validCredentials = false;
        this.invalidLogin = true
        if (error.status == 401)
          this.error = "Invalid Username or Password";
      }
    );
  }
}