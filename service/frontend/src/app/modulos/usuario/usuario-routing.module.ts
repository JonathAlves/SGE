import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ListagemComponent } from './components/listagem/listagem.component';



const routes: Routes = [
  {
      path: '',
  component: ListagemComponent},
  {
      path: 'formulario',
  component: FormularioComponent },
  {
        path: 'formulario/:id',
   component: FormularioComponent},


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioRoutingModule { }
