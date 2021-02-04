import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventoRoutingModule } from './evento-routing.module';

import { ListagemComponent } from './components/listagem/listagem.component';
import { EventoService} from './services/evento.service';
import { SharedModule } from 'src/app/shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PerguntaService } from '../pergunta/services/pergunta.service';
import {CalendarModule} from 'primeng/calendar';
import { FormularioComponent } from './components/formulario/formulario.component';




@NgModule({
  declarations: [FormularioComponent, ListagemComponent],
  providers: [
    EventoService, PerguntaService
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    EventoRoutingModule,
    SharedModule,
    HttpClientModule,
    CalendarModule
  ]
})
export class EventoModule { }
