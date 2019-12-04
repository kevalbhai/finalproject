import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchComponent } from './blood/search/search.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { BloodAvailabilityComponent } from './blood/blood-availability/blood-availability.component';
import { BloodRequireComponent } from './blood/blood-require/blood-require.component';
import { AboutusComponent } from './blood/aboutus/aboutus.component';
import { ContactusComponent } from './blood/contactus/contactus.component';
import { BloodDonationComponent } from './blood/blood-donation/blood-donation.component';
import { ExperienceSharingComponent } from './blood/experience-sharing/experience-sharing.component';
import { DonatingTipsComponent } from './blood/donating-tips/donating-tips.component';
import { AdminComponent } from './blood/admin/admin.component';


@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    SignupComponent,
    LoginComponent,
    BloodAvailabilityComponent,
    BloodRequireComponent,
    AboutusComponent,
    ContactusComponent,
    BloodDonationComponent,
    ExperienceSharingComponent,
    DonatingTipsComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
