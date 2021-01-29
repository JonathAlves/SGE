import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import { UsuarioModule } from './modulos/usuario/usuario.module';
import { EventoModule } from './modulos/evento/evento.module';
import {MinhaContaModule} from './modulos/minha-conta/minha-conta.module'

const routes: Routes = [
    { path: 'eventos', loadChildren: () => EventoModule},
    { path: 'usuarios', loadChildren: () => UsuarioModule},
    { path: 'minha-conta', loadChildren:() => MinhaContaModule},
    { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros'} },
    { path: 'login-success', component: LoginSuccessComponent },
  
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
