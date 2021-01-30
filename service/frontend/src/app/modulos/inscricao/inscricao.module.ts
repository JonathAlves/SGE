import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InscricaoRoutingModule } from './inscricao-routing.module';
import { InscricaoFormularioComponent } from './components/inscricao-formulario/inscricao-formulario.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [InscricaoFormularioComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    InscricaoRoutingModule,
    SharedModule,
    HttpClientModule
  ]
})
export class InscricaoModule { }
