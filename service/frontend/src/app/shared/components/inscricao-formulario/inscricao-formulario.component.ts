import { InscricaoResposta } from './../../../dominios/inscricao-resposta';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Evento } from 'src/app/dominios/evento';
import { Inscricao } from "src/app/dominios/inscricao";
import { Usuario } from 'src/app/dominios/usuario';
import { InscricaoService } from '../../../modulos/inscricao/servicos/inscricao.service';


@Component({
  selector: 'app-inscricao-formulario',
  templateUrl: './inscricao-formulario.component.html',
  styleUrls: ['./inscricao-formulario.component.css']
})
export class InscricaoFormularioComponent implements OnInit {
  
  usuario = new Usuario();
  evento = new Evento();
  @Input() inscricaoSalva = new EventEmitter<Inscricao>();
  @Input() inscricao = new Inscricao;
  usuarios: Usuario
  formInscricao: FormGroup;
  inscricaoResposta: InscricaoResposta;
  

  constructor(
    private fb: FormBuilder,
    private inscricaoService: InscricaoService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.inscrever();
  }
  
  inscrever(){
    const usuarioLocal: Usuario = JSON.parse(window.localStorage.getItem("usuario"));
    this.inscricao.idUsuario = usuarioLocal.id
    this.inscricao.idTipoSituacao = 1;  //valor padrão de aguardando aprovação
    this.route.params.subscribe(params => {
      if(params.id){
        this.buscarEvento(params.id)
        this.inscricao.idEvento = params.id
      }
    });    

      this.formInscricao = this.fb.group({
      resposta1: '',
    })

    this.inscricaoResposta.idEvento = this.inscricao.idEvento
    this.inscricaoResposta.idInscricao = this.inscricao.id
  }


  buscarEvento(id: number){
    this.inscricaoService.buscarEventoPorId(id)
      .subscribe(evento => {
        this.evento = evento
      }); 
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

