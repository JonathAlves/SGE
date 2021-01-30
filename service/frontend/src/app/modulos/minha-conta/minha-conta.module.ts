import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MinhaContaRoutingModule } from './minha-conta-routing.module';
import { ListagemInformacoesComponent } from './components/listagem-informacoes/listagem-informacoes.component';


@NgModule({
  declarations: [ListagemInformacoesComponent],
  imports: [
    CommonModule,
    MinhaContaRoutingModule
  ]
})
export class MinhaContaModule { }
