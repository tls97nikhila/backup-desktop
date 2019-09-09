import { TestBed } from '@angular/core/testing';

import { MuzixServiceService } from './muzix-service.service';

describe('MuzixServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MuzixServiceService = TestBed.get(MuzixServiceService);
    expect(service).toBeTruthy();
  });
});
