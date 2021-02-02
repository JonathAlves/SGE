import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InscricaoFormularioComponent } from './components/inscricao-formulario/inscricao-formulario.component';


const routes: Routes = [
  //{ path: '', component: ListagemComponent },
  { path: ':idEvento', component: InscricaoFormularioComponent },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InscricaoRoutingModule { }
