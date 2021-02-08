import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Evento } from "src/app/dominios/evento";
import { Pergunta } from 'src/app/dominios/pergunta';
import { PerguntaEvento } from 'src/app/dominios/pergunta-evento';
import { PerguntaService } from 'src/app/modulos/pergunta/services/pergunta.service';
import { EventoService } from '../../services/evento.service';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import * as moment from 'moment';
import { TipoEvento } from 'src/app/dominios/tipo-evento';
import { isValidDate } from '@fullcalendar/core';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {


  @Input() evento = new Evento();
  @Input() edicao = false;
  @Output() eventoSalvo = new EventEmitter<Evento>();
  
  perguntas: Pergunta[] = [];
  perguntasEventos: Pergunta[] =[];
  pergunta = new Pergunta;
  perguntaEvento: PerguntaEvento;
  novaPergunta: boolean;
  tipoInscricao: boolean = false;
  tipoEventos: TipoEvento[] = []
  tipoEvento: TipoEvento
  submitted: boolean;

  public formEvento: FormGroup;

  constructor(
    private fb: FormBuilder,
    private eventoService: EventoService,
    private perguntaService: PerguntaService,
    private route: ActivatedRoute,
    private messageService: MessageService, 
    private router: Router,
    private confirmationService: ConfirmationService
    ) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      if (params.id){
        this.edicao = true;
        this.buscarEvento(params.id);
        this.buscarPergunta(params.id);
      }
    })
    this.buscarTipoEventos()
    this.buscarPerguntas()

    this.formEvento = this.fb.group({
      titulo: ['', Validators.required],
      dataInicio:['', Validators.required],
      dataTermino:['', Validators.required],
      descricao:'',
      qtVagas:'',
      valor: '',
      local:['', Validators.required],
      tipoInscricao:['', Validators.required],
      idTipoEvento:['', Validators.required],
      perguntas:'',
      pergunta:'',
      perguntaEvento:'',
      obrigatoriedade: ''
    })
  }

  buscarEvento(id: number) {
    this.eventoService.buscarEventoPorId(id)
    .subscribe(evento => this.evento = evento);
  }

  salvar() {
      for (let perg of this.perguntasEventos) {
      this.perguntaEvento = new PerguntaEvento
      this.perguntaEvento.idEvento = null
      this.perguntaEvento.idPergunta = perg.id

      this.evento.perguntas.push(this.perguntaEvento)
    };
    if (this.edicao) {
      this.eventoService.editarEvento(this.evento)
      .subscribe(evento => {
        this.messageService.add({severity:'success', summary: 'Successo', detail: 'Evento Editado', life: 3000});
      }, (erro: HttpErrorResponse) => {
        this.messageService.add({severity:'error', summary: 'Error', detail: 'Evento não Editado', life: 3000});
      });
    }
     else {
      this.evento.tipoInscricao = this.tipoInscricao;
      this.evento.idTipoEvento = this.tipoEvento.id;
      this.eventoService.salvarEvento(this.evento)
      .subscribe(evento => {
        this.messageService.add({severity:'success', summary: 'Successo', detail: 'Evento Criado', life: 3000});
      }, (erro: HttpErrorResponse) => {
        this.messageService.add({severity:'error', summary: 'Error', detail: 'Evento não Criado', life: 3000});
      });
    }
  }

  buscarPergunta(id: number) {
    this.perguntaService.buscarPerguntaPorId(id)
    .subscribe(pergunta => this.pergunta = pergunta);
  }

  salvarPergunta(pergunta: Pergunta) {
    if(this.pergunta.obrigatoriedade == null){
      this.pergunta.obrigatoriedade = false;
    }
    this.perguntaService.salvarPergunta(pergunta)
    .subscribe(pergunta => {
      this.perguntasEventos.push(pergunta)
      this.messageService.add({severity:'success', summary: 'Successo', detail: 'Pergunta Criada', life: 3000});
      this.novaPergunta = false;
    }, (erro: HttpErrorResponse) => {
      this.messageService.add({severity:'error', summary: 'Error', detail: 'Pergunta não Criada', life: 3000});
    });
  }

  novasPerguntas(){
    this.novaPergunta = true
  }

  buscarTipoEventos(){
    this.eventoService.getTipoEventos().subscribe((tipoEventos: TipoEvento[]) =>{
      this.tipoEventos = tipoEventos;
    })
  }

  buscarTipoEvento(id: number){
    this.eventoService.getTipoEvento(id).subscribe(tipoEvento => 
      this.tipoEvento = tipoEvento
      )
  }

  buscarPerguntas(){
    this.perguntaService.getPerguntas().subscribe((perguntas: Pergunta[]) =>{
      this.perguntas = perguntas
    })
  }

  buscarPerguntaPorId(id: number){
    this.perguntaService.buscarPerguntaPorId(id).subscribe((pergunta: Pergunta) =>{
      this.pergunta = pergunta;
    })
  }

}
