import { Injectable } from '@angular/core';
import { UserServiceService } from './user-service.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class AuthServiceService {

  loggedInUser = { loggedOut: true };
  validCredentials: boolean = true;
  accessToken: string; // JWT token
  redirectUrl = '/';
  loggedIn: boolean = false;
  authenticationApiUrl: string = environment.baseUrl + "authenticate";
  constructor(private userService: UserServiceService, public router: Router, private _httpClient: HttpClient) { }

}