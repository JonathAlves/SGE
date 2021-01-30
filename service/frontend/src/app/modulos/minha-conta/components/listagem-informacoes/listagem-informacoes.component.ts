import { Component, OnInit } from '@angular/core';
import {MinhaContaService} from '../../services/minha-conta.service';
import { Usuario } from 'src/app/dominios/usuario';

@Component({
  selector: 'app-listagem-informacoes',
  templateUrl: './listagem-informacoes.component.html',
  styleUrls: ['./listagem-informacoes.component.css']
})
export class ListagemInformacoesComponent implements OnInit {
  usuarios: Usuario[] = [];

  constructor(
    private servico: MinhaContaService
  ) { }

  ngOnInit(): void {
  }

  private buscarUsuarios() {
    this.servico.getUsuarios()
      .subscribe((usuarios: Usuario[]) => {
        this.usuarios = usuarios;
      });
  }

}
