import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BloodService } from '../blood.service';
import { Experience } from '../Experience';

@Component({
  selector: 'app-experience-sharing',
  templateUrl: './experience-sharing.component.html',
  styleUrls: ['./experience-sharing.component.css']
})
export class ExperienceSharingComponent implements OnInit {

  experience: Experience;
  experienceCreated: boolean = null;
  experienceForm: FormGroup;
  error: string;

  constructor(private formBuilder: FormBuilder, private bloodservice: BloodService) { }

  ngOnInit() {
    this.experienceForm = this.formBuilder.group({
      hospitalname: ['', [
        Validators.required
      ]],
      city: ['', [
        Validators.required
      ]],
      feedback: ['', [
        Validators.required
      ]]
    });
  }
  get hospitalname(){
    return this.experienceForm.get('hospitalname');
  }
  get city(){
    return this.experienceForm.get('city');
  }
  get feedback(){
    return this.experienceForm.get('feedback');
  }

  addExperience(){
    this.experience = { id: null, city: this.experienceForm.value['city'], hospitalname: this.experienceForm.value['hospitalname'], feedback: this.experienceForm.value['feedback']};
    if(this.experience.city.length < 1 || this.experience.hospitalname.length < 1 || this.experience.feedback.length < 1){
      this.error = "‘Please update the highlighted mandatory field";
      this.experienceCreated = false;
    }
    else{
      this.bloodservice.addExperience(this.experience).subscribe( data => {
        if(data == true)
        {
         this.error = "Your Experience is visible on Home Page";
        }
      this.experienceCreated = true;
      });
    }

    }
}
