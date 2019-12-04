import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BloodService } from '../blood.service';
import { Slot } from '../Slot';

@Component({
  selector: 'app-blood-donation',
  templateUrl: './blood-donation.component.html',
  styleUrls: ['./blood-donation.component.css']
})
export class BloodDonationComponent implements OnInit {

  slot_: Slot;
  slotForm: FormGroup;
  error: string;
  slotCreated: boolean = null;
  slotList: Array<string> = [
    '10:00 AM - 11:00 AM','11:00 AM - 12:00 PM','12:00 PM - 01:00 PM','04:00 PM - 05:00 PM','05:00 PM - 06:00 PM'
  ]
  constructor(private formBuilder: FormBuilder, private bloodservice: BloodService) { }

  ngOnInit() {
    this.slotForm = this.formBuilder.group({
      hospitalname: ['', [
        Validators.required
      ]],
      date: ['', [
        Validators.required
      ]],
      slot: ['', [
        Validators.required
      ]]
  });
}

  get hospitalname(){
    return this.slotForm.get('hospitalname');
  }

  get date(){
    return this.slotForm.get('date');
  }

  get slot(){
    return this.slotForm.get('slot');
  }

  addSlot(){
    this.slot_ = {id: null,user_id: null, hospitalname: this.slotForm.value['hospitalname'], date: new Date(this.slotForm.value['date']), time: this.slotForm.value['slot'] };
    if(this.slot_.hospitalname.length < 1 || this.slot_.time.length < 1 || this.slot_.date.getFullYear == null){
      this.error = "‘Please update the highlighted mandatory field";
      this.slotCreated = false;
    }
    else{
      console.log("in component donation "+this.slot_.time);
      this.bloodservice.addSlot(this.slot_).subscribe( data => {
        if(data == true)
        {
         this.error = "Slot booked successfully, you are going to save a life";
        }
        if(data == false){
          this.error = "Sorry, please try a different slot";
        }
      this.slotCreated = true;
      });
    }
  }

}
