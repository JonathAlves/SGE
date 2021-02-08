import { InscricaoService } from '../../servicos/inscricao.service';
import { Usuario } from 'src/app/dominios/usuario';
import { Component, Input, OnInit } from '@angular/core';
import { Inscricao } from 'src/app/dominios/inscricao';
import { Evento } from 'src/app/dominios/evento';


@Component({
  selector: 'app-listagem',
  templateUrl: './inscricao-listagem.component.html',
  styleUrls: ['./inscricao-listagem.component.css']
})
export class InscricaoListagemComponent implements OnInit {

  @Input() usuario = new Usuario();
  inscricoes: Inscricao[] = [];
  eventos: Evento[] = [];
  evento: Evento;
  
  constructor(
    private servico: InscricaoService,
  ) { }

  ngOnInit(): void {
    this.buscarInscricoes();
    this.buscarEventos();
    this.buscaUsuario();
  }

  buscarInscricoes() {
    this.servico.getInscricoes()
    .subscribe((inscricoes: Inscricao[]) => {
      this.inscricoes = inscricoes;
    });
  }

   buscarEventos() {
      this.servico.getEventos()
      .subscribe((eventos: Evento[]) => {
        this.eventos = eventos
      })
      
    }
    
    buscaUsuario(){
      const usuarioLocal: Usuario = JSON.parse(window.localStorage.getItem("usuario"));
      this.usuario = usuarioLocal
    }

  deletarInscricao(id: number) {
    this.servico.deletarInscricao(id)
    .subscribe(() => {
      alert('Inscrição deletada!');
      this.buscarInscricoes();
    },
    err => alert(err));
  }

}
