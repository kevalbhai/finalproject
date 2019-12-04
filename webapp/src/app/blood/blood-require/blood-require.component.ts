import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Blood } from '../Blood';
import { BloodService } from '../blood.service';

@Component({
  selector: 'app-blood-require',
  templateUrl: './blood-require.component.html',
  styleUrls: ['./blood-require.component.css']
})
export class BloodRequireComponent implements OnInit {

  requirementCreated : boolean = null;
  requirementForm: FormGroup;
  blood: Blood;
  error: string;
  bloodGroup: any = ['A+','A-','B+','B-','AB+','AB-','O+','O-']
  stateList: Array<string> = [
    'Maharastra', 'Telangana', 'Gujarat'
  ];
  AreaList: Array<any>;
  state_: string;
  constructor(private formBuilder: FormBuilder, private bloodservice: BloodService) { }

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
    this.requirementForm = this.formBuilder.group({
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
    return this.requirementForm.get('pincode');
  }

  get area(){
    return this.requirementForm.get('area');
  }

  get state(){
    return this.requirementForm.get('state');
  }
  get bloodgroup(){
    return this.requirementForm.get('bloodgroup');
  }

  addRequirement(){
    this.blood = {id: null,bloodgroup: this.requirementForm.value['bloodgroup'], state: this.requirementForm.value['state'], area: this.requirementForm.value['area'], pincode: this.requirementForm.value['pincode']};
    if(this.blood.bloodgroup.length < 1 || this.blood.state.length <1 || this.blood.pincode == 0 ){
      this.error = "‘Please update the highlighted mandatory field";
      this.requirementCreated = false;
    }
    else{
      this.bloodservice.addRequirement(this.blood).subscribe(data => {
       if(data == true)
       {
         this.error = "Your blood requirements are posted successfully on the home page";
         this.requirementCreated = true
       }
      });
  }
}
}