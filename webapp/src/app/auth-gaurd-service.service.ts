import { Injectable } from '@angular/core';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Observable, Observer } from 'rxjs';
import { AuthenticationService } from './services/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {

  constructor(private authService: AuthenticationService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    this.authService.redirectUrl = state.url;
    return Observable.create((observer: Observer<boolean>) => {
      if (this.authService.loggedIn) {
        observer.next(true);
      } else {
        this.router.navigate(['login'], { queryParams: { from: state.url.substr(1) } });
      }
    });
  }
}
