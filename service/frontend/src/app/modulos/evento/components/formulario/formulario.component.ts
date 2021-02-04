import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Evento } from "src/app/dominios/evento";
import { Pergunta } from 'src/app/dominios/pergunta';
import { PerguntaEvento } from 'src/app/dominios/pergunta-evento';
import { PerguntaService } from 'src/app/modulos/pergunta/services/pergunta.service';
import { EventoService } from '../../services/evento.service';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import * as moment from 'moment';
import { TipoEvento } from 'src/app/dominios/tipo-evento';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {


  @Input() evento = new Evento();
  @Input() edicao = false;
  @Output() eventoSalvo = new EventEmitter<Evento>();
  formularioEdicao: boolean;
  perguntas: Pergunta[] = [];
  pergunta = new Pergunta;
  perguntaEvento: PerguntaEvento;
  perguntaObrigatoria: boolean;
  submetido: boolean;
  tipoInscricao: boolean = false;
  tipoEventos: TipoEvento[] = []

  public formEvento: FormGroup;

  constructor(
    private fb: FormBuilder,
    private eventoService: EventoService,
    private perguntaService: PerguntaService,
    private route: ActivatedRoute,
    private messageService: MessageService, 
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

    this.formEvento = this.fb.group({
      titulo: ['', Validators.required],
      dataInicio:'',
      dataTermino:'',
      descricao:'',
      qtVagas:'',
      valor: '',
      local:'',
      tipoInscricao:'',
      idTipoEvento:'',
      perguntas:''
    })
  }

  buscarEvento(id: number) {
    this.eventoService.buscarEventoPorId(id)
    .subscribe(evento => this.evento = evento);
  }

  salvar() {
    this.submetido = true;
    if (this.formEvento.invalid) {
      this.messageService.add({severity:'warn', summary: 'Atenção', detail: 'Preencha os campos solicitados', life: 3000});
      return;
    }
    if (this.edicao) {
      this.eventoService.editarEvento(this.evento)
      .subscribe(evento => {
        this.messageService.add({severity:'success', summary: 'Successo', detail: 'Evento Editado', life: 3000});
      }, (erro: HttpErrorResponse) => {
        this.messageService.add({severity:'error', summary: 'Error', detail: 'Evento não Editado', life: 3000});
      });
    } else {
      this.eventoService.salvarEvento(this.evento)
      .subscribe(evento => {
        this.messageService.add({severity:'success', summary: 'Successo', detail: 'Evento Criado', life: 3000});
      }, (erro: HttpErrorResponse) => {
        this.messageService.add({severity:'error', summary: 'Error', detail: 'Evento não Criado', life: 3000});
      });
    }
  }

  fecharDialog(eventoSalvo: Evento) {
    this.eventoSalvo.emit(eventoSalvo);
    this.submetido = false;
  }

  buscarPergunta(id: number) {
    this.perguntaService.buscarPerguntaPorId(id)
    .subscribe(pergunta => this.pergunta = pergunta);
  }

  salvarPergunta() {
    this.perguntaService.salvarPergunta(this.pergunta)
    .subscribe(pergunta => {
      alert('Pergunta Salva')
      this.perguntaObrigatoria = false;
    }, (erro: HttpErrorResponse) => {
      alert(erro.error.message);
    });
  }

  obrigatoria() {
    this.perguntaObrigatoria = true;
  }

}
