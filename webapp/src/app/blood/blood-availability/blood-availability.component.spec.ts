import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodAvailabilityComponent } from './blood-availability.component';

describe('BloodAvailabilityComponent', () => {
  let component: BloodAvailabilityComponent;
  let fixture: ComponentFixture<BloodAvailabilityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BloodAvailabilityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BloodAvailabilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
