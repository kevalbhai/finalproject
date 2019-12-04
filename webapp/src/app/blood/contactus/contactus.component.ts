import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { query } from './query';
import { BloodService } from '../blood.service';

@Component({
  selector: 'app-contactus',
  templateUrl: './contactus.component.html',
  styleUrls: ['./contactus.component.css']
})
export class ContactusComponent implements OnInit {

  queryCreated: boolean = null;
  error: string;
  query_: query;
  queryForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private bloodservice: BloodService) { }

  ngOnInit() {
    this.queryForm = this.formBuilder.group({
      email: ['', [
        Validators.required,
       // this.isUsernameTaken
      ]],
      name: ['', [
        Validators.required
      ]],
      query: ['', [
        Validators.required
      ]],
      contact: ['', [
        Validators.required
      ]]
     })
  }

  get contact(){
    return this.queryForm.get('contact');
  }

  get email() {
    return this.queryForm.get('email');
  }

  get query() {
    return this.queryForm.get('query');
  }

  get name() {
    return this.queryForm.get('name');
  }

  addQuery(){
    this.query_ = { name: this.queryForm.value['name'], email: this.queryForm.value['email'], contact: this.queryForm.value['contact'], query: this.queryForm.value['query'] };
    this.bloodservice.addQuery(this.query_).subscribe(data => {
      this.queryCreated = true;
      this.error = "Query submitted. kindly wait for admin to respond"
    })
  }

}

