import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodRequireComponent } from './blood-require.component';

describe('BloodRequireComponent', () => {
  let component: BloodRequireComponent;
  let fixture: ComponentFixture<BloodRequireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BloodRequireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BloodRequireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
