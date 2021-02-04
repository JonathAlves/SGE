import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemInformacoesComponent } from './listagem-informacoes.component';

describe('ListagemInformacoesComponent', () => {
  let component: ListagemInformacoesComponent;
  let fixture: ComponentFixture<ListagemInformacoesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListagemInformacoesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListagemInformacoesComponent);
    component = fixture.componentInstance; 
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
