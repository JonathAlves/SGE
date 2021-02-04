import { UsuarioService } from './../services/usuario.service';
import { ActivatedRoute } from '@angular/router';
import { EventoService } from './../../../modulos/evento/services/evento.service';
import { ListagemComponent } from './../../../modulos/evento/components/listagem/listagem.component';
import { ListagemInformacoesComponent } from './../../../modulos/minha-conta/components/listagem-informacoes/listagem-informacoes.component';
import { Evento } from 'src/app/dominios/evento';
import { Usuario } from 'src/app/dominios/usuario';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Inscricao } from "src/app/dominios/inscricao";
import { InscricaoService } from '../../../modulos/inscricao/servicos/inscricao.service';


@Component({
  selector: 'app-inscricao-formulario',
  templateUrl: './inscricao-formulario.component.html',
  styleUrls: ['./inscricao-formulario.component.css']
})
export class InscricaoFormularioComponent implements OnInit {
  
  @Input() usuario = new Usuario();
  @Input() evento = new Evento();
  @Input() inscricaoSalva = new EventEmitter<Inscricao>();
 
  formInscricao: FormGroup;
  inscricao = new Inscricao;
  usrLogado: ListagemInformacoesComponent;
  eventoList: ListagemComponent;
  eventoService: EventoService
  route: ActivatedRoute;
  usuarioService: UsuarioService;

  constructor(
    private fb: FormBuilder,
    private inscricaoService: InscricaoService,
    
  ) {}

  ngOnInit(): void {
    this.inscrever();
  }
  
  inscrever(){
    
  }
 
     

  salvar() {
      this.inscricaoService.salvarInscricao(this.inscricao)
        .subscribe(inscricao => {
          alert('Inscricao salva!');
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    }
}

