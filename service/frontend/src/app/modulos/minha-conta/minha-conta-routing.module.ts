import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormularioComponent } from 'src/app/shared/components/formulario/formulario.component';
import { ListagemInformacoesComponent } from './components/listagem-informacoes/listagem-informacoes.component';


const routes: Routes = [
  {
    path: 'formulario',
component: FormularioComponent},

{path: '', component: ListagemInformacoesComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MinhaContaRoutingModule { }