import { TestBed } from '@angular/core/testing';

import { EventoService } from './evento.service';

describe('EventoService', () => {
  let service: EventoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
