import { Component, OnInit, Input } from '@angular/core';
import { BloodService } from 'src/app/blood/blood.service';
import { Blood } from 'src/app/blood/Blood';
import { Experience } from 'src/app/blood/Experience';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  experienceList: Experience[];
  bloodRequireList: Blood[];
  searchKey: string;
  isAdmin: boolean;

  constructor(private bloodservice: BloodService) { }

  ngOnInit() {
      this.bloodservice.getBloodRequireList().subscribe( data => {
        this.bloodRequireList = data;
        console.log(this.bloodRequireList);
        
      })
      this.bloodservice.getExperienceList().subscribe( data => {
        this.experienceList = data;
        console.log(this.experienceList);
        
      })
    
  }

  
}
