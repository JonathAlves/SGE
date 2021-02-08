import { InscricaoService } from './../../../modulos/inscricao/servicos/inscricao.service';
import { PerguntaService } from 'src/app/modulos/pergunta/services/pergunta.service';
import { PerguntaEvento } from 'src/app/dominios/pergunta-evento';
import { InscricaoResposta } from './../../../dominios/inscricao-resposta';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Evento } from 'src/app/dominios/evento';
import { Inscricao } from "src/app/dominios/inscricao";
import { Usuario } from 'src/app/dominios/usuario';
import { Pergunta } from 'src/app/dominios/pergunta';


@Component({
  selector: 'app-inscricao-formulario',
  templateUrl: './inscricao-formulario.component.html',
  styleUrls: ['./inscricao-formulario.component.css']
})
export class InscricaoFormularioComponent implements OnInit {
  
  usuario = new Usuario();
  evento = new Evento();
  perguntas: Pergunta[] = [];
  perguntaSeparada: Pergunta[] = [];
  perguntasEventos: PerguntaEvento[] =[];
  pergunta = new Pergunta;
  perguntaEvento: PerguntaEvento;
  @Input() inscricaoSalva = new EventEmitter<Inscricao>();
  @Input() inscricao = new Inscricao;
  usuarios: Usuario;
  formInscricao: FormGroup;
  inscricaoResposta: InscricaoResposta;
  inscricoesResp: InscricaoResposta[] = [];
  perguntaService: PerguntaService;
  respostas: string[];

  constructor(
    private fb: FormBuilder,
    private inscricaoService: InscricaoService,
    private route: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.inscrever();

    this.formInscricao = this.fb.group({
      resposta: ''
    })
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

    for (let resp of this.inscricoesResp) {
      this.inscricaoResposta = new InscricaoResposta;
      this.inscricaoResposta.idEvento = this.inscricao.idEvento;
      this.inscricaoResposta.idPergunta = resp.idPergunta;
      this.respostas.push(this.inscricaoResposta.resposta);
      this.inscricao.respostas.push(this.inscricaoResposta);
    };
    this.buscarPerguntas();
      }


  buscarEvento(id: number){
    this.inscricaoService.buscarEventoPorId(id)
      .subscribe(evento => {
        this.evento = evento
        this.perguntasEventos = this.evento.perguntas
      })   
  }

  buscarPerguntas(){
    this.inscricaoService.getPerguntas()
    .subscribe((perguntas: Pergunta[]) => {
      this.perguntas = perguntas;
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

