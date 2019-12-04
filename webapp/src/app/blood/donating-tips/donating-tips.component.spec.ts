import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonatingTipsComponent } from './donating-tips.component';

describe('DonatingTipsComponent', () => {
  let component: DonatingTipsComponent;
  let fixture: ComponentFixture<DonatingTipsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonatingTipsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonatingTipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
