import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { UserServiceService } from '../user-service.service';
import { User } from '../User/User';

import { BloodService } from 'src/app/blood/blood.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signUpForm: FormGroup;
  user: User;
  userCreated: boolean = null;
  error: string;
  Gender: any = ['Male','Female']
  bloodGroup: any = ['A+','A-','B+','B-','AB+','AB-','O+','O-']
 
  stateList: Array<string> = [
    'Maharastra', 'Telangana', 'Gujarat'
  ];
  AreaList: Array<any>;
  state_: string;

  constructor(private formBuilder: FormBuilder, private _userService: UserServiceService, private bloodservice: BloodService) { }

  onSelectState(event:any){
    console.log("in on select state "+event.target.value);
  
    this.state_ = event.target.value;
  
    if(this.state_ == 'Maharastra'){
      this.AreaList = ['Mumbai','Pune','Solapur','Nagpur','Nashik'];
    }
    else if(this.state_ == 'Telangana'){
      this.AreaList = ['Hyderabad','Warangal','Nizamabad','Suryapet'];
    }
    else if(this.state_ == 'Gujarat'){
      this.AreaList = ['Ahmedabad','Rajkot','Surat','Vapi'];
    }
    console.log(this.AreaList+"----");
  }
  ngOnInit() {
   // this.stateList = this.bloodservice.getStates();
    this.signUpForm = this.formBuilder.group({
      email: ['', [
        Validators.required,
       // this.isUsernameTaken
      ]],
      firstname: ['', [
        Validators.required
      ]],
      lastname: ['', [
        Validators.required
      ]],
      password: ['', [
        Validators.required
      ]],
      confirmPassword: ['', [
        Validators.required,
        this.matchConfirmPassword.bind(this)
      ]],
      age: ['', [
        Validators.required
      ]],
      bloodgroup: ['', [
        Validators.required
      ]],
      gender: ['', [
        Validators.required
      ]],
      weight: ['', [
        Validators.required
      ]],
      contact: ['', [
        Validators.required
      ]],
      state: ['', [
        Validators.required
      ]],
      area: ['', [
        Validators.required
      ]],
      pincode: ['', [
        Validators.required
      ]]
    })
  }

  get pincode(){
    return this.signUpForm.get('pincode');
  }

  get area(){
    return this.signUpForm.get('area');
  }

  get state(){
    return this.signUpForm.get('state');
  }

  get contact(){
    return this.signUpForm.get('contact');
  }

  get weight(){
    return this.signUpForm.get('weight');
  }

  get gender(){
    return this.signUpForm.get('gender');
  }
  get bloodgroup(){
    return this.signUpForm.get('bloodgroup');
  }

  get age(){
    return this.signUpForm.get('age');
  }
  get email() {
    return this.signUpForm.get('email');
  }
  get firstname() {
    return this.signUpForm.get('firstname');
  }
  get lastname() {
    return this.signUpForm.get('lastname');
  }
  get password() {
    return this.signUpForm.get('password');
  }
  get confirmPassword() {
    return this.signUpForm.get('confirmPassword');
  }
  matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
    if (this.signUpForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signUpForm.get('password').value) {
        return { 'nomatch': true };
      }
    }
    return null;
  }
  isUsernameTaken(formControl: FormControl): { [s: string]: boolean } {
    if (formControl.value === 'admin') {
      return { 'EmailTaken': true };
    } else {
      return null;
    }
  }

  addUser() {
    this.user = { id: null, firstname: this.signUpForm.value['firstname'], lastname: this.signUpForm.value['lastname'], password: this.signUpForm.value['password'], email: this.signUpForm.value['email'], age: this.signUpForm.value['age'], bloodgroup: this.signUpForm.value['bloodgroup'], gender: this.signUpForm.value['gender'], weight: this.signUpForm.value['weight'], contact: this.signUpForm.value['contact'], state: this.signUpForm.value['state'], area: this.signUpForm.value['area'], pincode: this.signUpForm.value['pincode'], roleList: null, bloodrequireList: null, experienceList: null };
    if(this.user.area.length < 1 || this.user.lastname.length < 1 || this.user.firstname.length < 1 || this.user.contact == 0 || this.user.email.length < 5 || this.user.bloodgroup.length < 1 || this.user.state.length <1 || this.user.pincode == 0 ){
      this.error = "Please update the highlighted mandatory field";
      this.userCreated = false;
    }
    else{
      this._userService.addUser(this.user).subscribe(data => {
        this.userCreated = true;
        this.error = "Signed Up Successfull.Go to "
      },
        error => {
          if (error.status == 400||error.status == 500) {
            this.error = "Email Already Exists";
            this.userCreated = false;
          }
        }
      );
    }
    
  }
}
