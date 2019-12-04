import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  ngOnInit(): void {
    this.loggedIn();
    this.router.navigate(['search-bar']);
  }
  constructor(private authService: AuthenticationService, public router: Router) {
  }
  title = 'BloodBank';
  isLoggedIn: boolean = false;
  loggedIn(): boolean {
    if (this.authService.loggedIn) {
      this.isLoggedIn = true;
      return true
    }
    else {
      this.isLoggedIn = false;
      return false;
    }
  }
  
  exit() {
    window.location.reload();
  }
}
