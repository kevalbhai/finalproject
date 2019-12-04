import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { SearchComponent } from './blood/search/search.component';
import { BloodRequireComponent } from './blood/blood-require/blood-require.component';
import { BloodAvailabilityComponent } from './blood/blood-availability/blood-availability.component';
import { AboutusComponent } from './blood/aboutus/aboutus.component';
import { ContactusComponent } from './blood/contactus/contactus.component';
import { BloodDonationComponent } from './blood/blood-donation/blood-donation.component';
import { ExperienceSharingComponent } from './blood/experience-sharing/experience-sharing.component';
import { DonatingTipsComponent } from './blood/donating-tips/donating-tips.component';

const routes: Routes = [
  { path: 'signup', component: SignupComponent },
  { path: 'login', component: LoginComponent },
  { path: 'search-bar', component: SearchComponent },
  { path: 'bloodrequire', component: BloodRequireComponent},
  { path: 'bloodavailability', component: BloodAvailabilityComponent},
  { path: 'aboutus', component: AboutusComponent},
  { path: 'contactus', component: ContactusComponent},
  { path: 'blooddonation', component: BloodDonationComponent},
  { path: 'experience', component: ExperienceSharingComponent},
  { path: 'tips', component: DonatingTipsComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
