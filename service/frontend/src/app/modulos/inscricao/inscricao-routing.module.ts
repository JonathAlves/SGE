import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InscricaoFormularioComponent } from './components/inscricao-formulario/inscricao-formulario.component';
import { InscricaoListagemComponent } from './components/inscricao-listagem/inscricao-listagem.component';


const routes: Routes = [
  { path: '', component: InscricaoListagemComponent },
  { path: 'formulario', component: InscricaoFormularioComponent},
  { path: 'formulario/:id', component: InscricaoFormularioComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InscricaoRoutingModule { }
