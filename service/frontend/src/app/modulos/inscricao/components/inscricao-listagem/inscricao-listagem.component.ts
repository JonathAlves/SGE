import { InscricaoService } from '../../servicos/inscricao.service';
import { Usuario } from 'src/app/dominios/usuario';
import { Component, Input, OnInit } from '@angular/core';
import { Inscricao } from 'src/app/dominios/inscricao';


@Component({
  selector: 'app-listagem',
  templateUrl: './inscricao-listagem.component.html',
  styleUrls: ['./inscricao-listagem.component.css']
})
export class InscricaoListagemComponent implements OnInit {

  @Input() usuario = new Usuario();
  inscricoes: Inscricao[] = [];

  constructor(
    private servico: InscricaoService,
  ) { }

  ngOnInit(): void {
    this.buscarInscricoes();
  }

  buscarInscricoes() {
    this.servico.getInscricoes()
    .subscribe((inscricoes: Inscricao[]) => {
      this.inscricoes = inscricoes;
    });
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
