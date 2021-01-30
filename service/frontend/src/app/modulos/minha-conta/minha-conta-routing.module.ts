import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListagemInformacoesComponent } from './components/listagem-informacoes/listagem-informacoes.component';


const routes: Routes = [
{path: 'minha-conta', component: ListagemInformacoesComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MinhaContaRoutingModule { }
