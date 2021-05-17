import { TestBed } from '@angular/core/testing';

import { AdminSideService } from './admin-side.service';

describe('AdminSideService', () => {
  let service: AdminSideService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminSideService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
