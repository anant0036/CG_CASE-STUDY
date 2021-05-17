import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillItComponent } from './bill-it.component';

describe('BillItComponent', () => {
  let component: BillItComponent;
  let fixture: ComponentFixture<BillItComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BillItComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BillItComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
