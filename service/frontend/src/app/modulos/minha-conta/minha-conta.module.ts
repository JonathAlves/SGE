import { MinhaContaService } from './service/minha-conta.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// import { MinhaContaRoutingModule } from './minha-conta-routing.module';
// import { ListagemInformacoesComponent } from './components/listagem-informacoes/listagem-informacoes.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UsuarioService } from 'src/app/shared/components/services/usuario.service';



@NgModule({
  // declarations: [ListagemInformacoesComponent],
  
  imports: [
    CommonModule,
    // MinhaContaRoutingModule,
    SharedModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  
  ],

  providers: [
   UsuarioService,
   MinhaContaService
  ]
})
export class MinhaContaModule { }
