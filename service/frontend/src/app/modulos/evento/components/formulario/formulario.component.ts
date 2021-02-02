import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Evento } from "src/app/dominios/evento";
import { EventoService } from '../../services/evento.service';

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

  public formEvento: FormGroup;

  constructor(
    private fb: FormBuilder,
    private eventoService: EventoService,
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      if (params.id){
        this.edicao = true;
        this.buscarEvento(params.id);
      }
    })

    this.formEvento = this.fb.group({
      titulo: '',
      dataInicio:'',
      dataTermino:'',
      descricao:'',
      qtVagas:'',
      valor: '',
      local:'',
      tipoInscricao:'',
      idTipoEvento:'',
    })
  }

  buscarEvento(id: number) {
    this.eventoService.buscarEventoPorId(id)
    .subscribe(evento => this.evento = evento);
  }

  salvar() {
    if (this.formEvento.invalid) {
      alert('Formulário inválido');
      return;
    }
    if (this.edicao) {
      this.eventoService.editarEvento(this.evento)
      .subscribe(evento => {
        alert('Evento Editado!')
      }, (erro: HttpErrorResponse) => {
        alert(erro.error.message);
      });
    } else {
      this.eventoService.salvarEvento(this.evento)
      .subscribe(usuario => {
        console.log('usuario salvo', usuario);
        alert('Evento Salvo')
      }, (erro: HttpErrorResponse) => {
        alert(erro.error.message);
      });
    }
  }

  fecharDialog(eventoSalvo: Evento) {
    this.eventoSalvo.emit(eventoSalvo);
  }

}
