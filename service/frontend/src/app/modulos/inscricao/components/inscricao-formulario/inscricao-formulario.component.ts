import { Evento } from 'src/app/dominios/evento';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Inscricao } from "src/app/dominios/inscricao";
import { InscricaoService } from './../../servicos/inscricao.service';
import { InscricaoResposta } from 'src/app/dominios/inscricao-resposta';
import { Usuario } from 'src/app/dominios/usuario';
import { EventoService } from 'src/app/modulos/evento/services/evento.service';
import { UsuarioService } from 'src/app/modulos/usuario/services/usuario.service';


@Component({
  selector: 'app-inscricao-formulario',
  templateUrl: './inscricao-formulario.component.html',
  styleUrls: ['./inscricao-formulario.component.css']
})
export class InscricaoFormularioComponent implements OnInit {

  formInscricao: FormGroup;
  inscricao = new Inscricao;
  respostas: InscricaoResposta[] = [];
  evento = new Evento();
  usuario = new Usuario();

  private eventoService: EventoService
  private usuarioService: UsuarioService


  constructor(
    private fb: FormBuilder,
    private inscricaoService: InscricaoService,
    private route: ActivatedRoute,
    private inscricaoResposta: InscricaoResposta
    
  ) {
    
   }

  ngOnInit(): void {
    this.formInscricao = this.fb.group({
      resposta1: this.inscricaoResposta.resposta
    })  
  }
  

  inscrever(){
    
    if (this.formInscricao.invalid) {
      alert('Formulário inválido');
      return;
    }

    this.eventoService.buscarEventoPorId(this.evento.id)
    this.inscricao.idEvento = 
    this.inscricao.idTipoSituacao = 1
    
      this.inscricaoService.salvarInscricao(this.inscricao)
      .subscribe(inscricao => {
        console.log('inscricao salva', inscricao);
        alert('Inscrição Salva!')
      }, (erro: HttpErrorResponse) => {
        alert(erro.error.message);
      });
    }
  }

