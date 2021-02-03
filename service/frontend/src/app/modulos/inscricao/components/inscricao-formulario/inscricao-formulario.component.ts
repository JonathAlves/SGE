import { Evento } from 'src/app/dominios/evento';
import { Usuario } from 'src/app/dominios/usuario';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Inscricao } from "src/app/dominios/inscricao";
import { InscricaoService } from './../../servicos/inscricao.service';
import { InscricaoResposta } from 'src/app/dominios/inscricao-resposta';
import { EventoService } from 'src/app/modulos/evento/services/evento.service'
import { UsuarioService } from 'src/app/modulos/usuario/services/usuario.service';


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
  respostas: InscricaoResposta[] = [];

  private eventoService: EventoService
  private usuarioService: UsuarioService
  private inscricaoResposta: InscricaoResposta

  constructor(
    private fb: FormBuilder,
    private inscricaoService: InscricaoService,
    private route: ActivatedRoute,  
  ) {}

  ngOnInit(): void {
    this.inscrever();
  }
  
  inscrever(){
    this.route.params.subscribe(params => {
      if (params.id) {
        this.getUsuario(params.id);
        this.getEvento(params.id);
      }
    });
    this.inscricao.id = Math.random();
    this.inscricao.idTipoSituacao = 1;
    
    
    this.formInscricao = this.fb.group({
      resposta1: '',
    }) 
  }

  getUsuario(idUsuario: number){
      this.usuarioService.buscarUsuarioPorId(idUsuario)
      .subscribe(usuario => this.usuario = usuario);
  }

  getEvento(idEvento: number){
    this.eventoService.buscarEventoPorId(idEvento)
    .subscribe(evento => this.evento = evento);

  }


  salvar() {
    if (this.formInscricao.invalid) {
      alert('Formulário inválido');
      return;
    } else {
      this.inscricaoService.salvarInscricao(this.inscricao)
        .subscribe(inscricao => {
          alert('Inscricao salva!');
          this.fecharDialog(inscricao);
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    }
  }

  fecharDialog(inscricaoSalva: Inscricao) {
    this.inscricaoSalva.emit(inscricaoSalva);
  }
}