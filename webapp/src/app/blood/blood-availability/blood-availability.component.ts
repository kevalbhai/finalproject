import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Blood } from '../Blood';
import { BloodService } from '../blood.service';
import { User } from 'src/app/site/User/User';
import { error } from 'util';

@Component({
  selector: 'app-blood-availability',
  templateUrl: './blood-availability.component.html',
  styleUrls: ['./blood-availability.component.css']
})
export class BloodAvailabilityComponent implements OnInit {

  isUserNull: boolean = null;
  isSearchClicked: boolean = null;
  errorBoolean: boolean = null;
  bloodAvailableForm: FormGroup;
  blood: Blood;
  error: string;
  bloodGroup: any = ['A+','A-','B+','B-','AB+','AB-','O+','O-']
  stateList: Array<string> = [
    'Maharastra', 'Telangana', 'Gujarat'
  ];
  AreaList: Array<any>;
  state_: string;
  users: User[];

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
  constructor(private formBuilder: FormBuilder, private bloodservice: BloodService) { }

  ngOnInit() {
    this.bloodAvailableForm = this.formBuilder.group({
      bloodgroup: ['', [
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
    return this.bloodAvailableForm.get('pincode');
  }

  get area(){
    return this.bloodAvailableForm.get('area');
  }

  get state(){
    return this.bloodAvailableForm.get('state');
  }
  get bloodgroup(){
    return this.bloodAvailableForm.get('bloodgroup');
  }

  onSubmit(){
    this.blood = {id: null,bloodgroup: this.bloodAvailableForm.value['bloodgroup'], state: this.bloodAvailableForm.value['state'], area: this.bloodAvailableForm.value['area'], pincode: this.bloodAvailableForm.value['pincode']};
    console.log("--"+ this.blood.pincode+" -"+this.blood.state+this.blood.bloodgroup+this.blood.area)
    if(this.blood.bloodgroup.length < 1 || this.blood.state.length <1 || this.blood.pincode == 0 ){
      this.error = "Please fill the details appropriately";
      this.errorBoolean=true;
    }
    else{
      this.bloodservice.bloodAvailable(this.blood).subscribe(data => {
        this.users = data;
        console.log(this.users);
        if(this.users.length==0){
          this.isUserNull = true;
        }
        else {
          this.isSearchClicked=true;
        }
        
       },
       error=>{
         console.log("in error");
       })
    }
    //console.log(this.users+"--");
    
//    this.error = "Please fill the form appropriately";
  }
  checkUsers(){
    
  }

}
