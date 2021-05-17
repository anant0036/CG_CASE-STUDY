import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResAddformComponent } from './res-addform.component';

describe('ResAddformComponent', () => {
  let component: ResAddformComponent;
  let fixture: ComponentFixture<ResAddformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResAddformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResAddformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
