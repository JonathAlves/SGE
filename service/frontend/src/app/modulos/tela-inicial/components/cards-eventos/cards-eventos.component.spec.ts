import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CardsEventosComponent } from './cards-eventos.component';

describe('CardsEventosComponent', () => {
  let component: CardsEventosComponent;
  let fixture: ComponentFixture<CardsEventosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CardsEventosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardsEventosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
