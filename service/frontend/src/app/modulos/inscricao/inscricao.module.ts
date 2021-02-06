import { InscricaoService } from './servicos/inscricao.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InscricaoRoutingModule } from './inscricao-routing.module';
import { InscricaoFormularioComponent } from '../../shared/components/inscricao-formulario/inscricao-formulario.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from 'src/app/shared/shared.module';
import { InscricaoListagemComponent } from './components/inscricao-listagem/inscricao-listagem.component';


@NgModule({
  declarations: [InscricaoFormularioComponent, InscricaoListagemComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    InscricaoRoutingModule,
    SharedModule,
    HttpClientModule
  ],
  providers: [
    InscricaoService
  ]
})
export class InscricaoModule { }
