import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { query } from './contactus/query';
import { HttpClient } from '@angular/common/http';
import { Blood } from './Blood';
import { User } from '../site/User/User';
import { AuthenticationService } from '../services/authentication.service';
import { Experience } from './Experience';
import { Slot } from './Slot';

@Injectable({
  providedIn: 'root'
})
export class BloodService {

  constructor(private _httpClient: HttpClient, private authService: AuthenticationService) { }
  url: string = environment.baseUrl;
  addQuery(query_: query){
    console.log("inside addQuery");
    console.log(query_);
    return this._httpClient.post<any>(this.url+"blood-service/query", query_);    
  }

  bloodAvailable(blood: Blood){
    console.log("in service "+ blood.pincode + blood.area + blood.state );
    return this._httpClient.post<any[]>(this.url+"blood-service/availability", blood);
  }

  addRequirement(blood: Blood){
    console.log("in service "+blood.bloodgroup+blood.pincode);
    return this._httpClient.post<any>(this.url+"blood-service/bloodrequire/"+this.authService.email, blood);
  }

  addExperience(experience: Experience){
    console.log("in service "+experience.feedback+experience.hospitalname);
    return this._httpClient.post<any>(this.url+"blood-service/experience/"+this.authService.email, experience);
    
  }

  getBloodRequireList(){
    return this._httpClient.get<any>(this.url+"blood-service/bloodrequire");
  }

  getExperienceList(){
    return this._httpClient.get<any>(this.url+"blood-service/experience");
  }

  addSlot(slot: Slot){
    console.log(slot);    
    return this._httpClient.post<any>(this.url+"blood-service/slotbooking/"+this.authService.email, slot);
  }

}
