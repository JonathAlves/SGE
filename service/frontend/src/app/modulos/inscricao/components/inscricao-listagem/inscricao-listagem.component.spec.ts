import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InscricaoListagemComponent } from './inscricao-listagem.component';

describe('InscricaoListagemComponent', () => {
  let component: InscricaoListagemComponent;
  let fixture: ComponentFixture<InscricaoListagemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InscricaoListagemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InscricaoListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
