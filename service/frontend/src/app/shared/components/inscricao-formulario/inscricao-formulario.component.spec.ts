import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InscricaoFormularioComponent } from './inscricao-formulario.component';

describe('InscricaoFormularioComponent', () => {
  let component: InscricaoFormularioComponent;
  let fixture: ComponentFixture<InscricaoFormularioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InscricaoFormularioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InscricaoFormularioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
