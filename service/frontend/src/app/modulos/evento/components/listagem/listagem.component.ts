import { Component, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng';
import { Evento } from 'src/app/dominios/evento';
import { EventoService } from '../../services/evento.service';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {

  eventos: Evento[] = [];
  evento = new Evento();
  selectedEvento: Evento[] = [];
  formularioEdicao: boolean;
  exibirDialog = false;

  statuses: any[];

  constructor(
    private servico: EventoService,
    private confirmationService: ConfirmationService
  ) { }

  ngOnInit(): void {
    this.buscarEventos();
    
    this.statuses = [
      {label: 'INSTOCK', value: 'instock'},
      {label: 'LOWSTOCK', value: 'lowstock'},
  ];
  }

  private buscarEventos() {
    this.servico.getEventos()
    .subscribe((eventos: Evento[]) => {
      this.eventos = eventos;
    });
  }

  mostrarDialogEditar(id: number) {
    this.servico.buscarEventoPorId(id)
      .subscribe(evento => {
        this.evento = evento
        this.mostrarDialog();
      }); 
  }

  mostrarDialog(idicao = false) {

    this.exibirDialog = true;
    this.formularioEdicao = idicao;
  }

  fecharDialog(eventoSalvo: Evento) {
    this.exibirDialog = false;
    this.buscarEventos();
  }

  confirmarDeletarevento(id: number) {
    this.confirmationService.confirm({
        message: 'Tem certeza que deseja excluir o usuário?',
        accept: () => {
          this.deletarEvento(id);
        }
    });
  }

  deletarEvento(id: number) {
    this.servico.deletarEvento(id)
    .subscribe(() => {
      alert('Evento deletado!');
      this.buscarEventos();
    },
    err => alert(err));
  }


}
