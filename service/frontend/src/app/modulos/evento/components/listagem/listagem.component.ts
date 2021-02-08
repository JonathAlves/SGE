import { Component, OnInit } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng';
import { Evento } from 'src/app/dominios/evento';
import { Usuario } from 'src/app/dominios/usuario';
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
  exibirDialog: boolean = false;
  usuarioLogado: Usuario;
  statuses: any[];

  constructor(
    private servico: EventoService,
    private messageService: MessageService,
    private confirmationService: ConfirmationService
  ) { }

  ngOnInit(): void {
    this.buscarEventos();
    this.usuarioLogado = JSON.parse(localStorage.getItem('usuario')) as Usuario;
    
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
        this.evento = evento;
        this.mostrarDialog(true);
      }); 
  }

  mostrarDialog(edicao = false) {
    console.log(edicao)
    this.exibirDialog = true;
    this.formularioEdicao = edicao;
  }

  fecharDialog(eventoSalvo: Evento) {
    this.exibirDialog = false;
    this.buscarEventos();
  }

  confirmarDeletarevento(id: number) {
    this.confirmationService.confirm({
        message: 'Tem certeza que deseja excluir o evento?',
        accept: () => {
          this.deletarEvento(id);
        }
    });
  }

  deletarTodosEvento() {
    this.confirmationService.confirm({
      message: 'Você tem certeza que quer deletar os eventos selecionados? ',
      header: 'Confirme',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.eventos = this.eventos.filter(val => !this.selectedEvento.includes(val));
        this.selectedEvento.forEach(evento => {
          this.servico.deletarEvento(evento.id).subscribe(() => { 
            this.messageService.add({severity:'success', summary: 'Successo', detail: 'Eventos Deletados', life: 3000});
            this.buscarEventos();
            this.selectedEvento = [];
          }, err => alert(err));
        });
      }
  });
  }

  deletarEvento(id: number) {
    this.confirmationService.confirm({
      message: 'Você tem certeza que quer deletar este evento?',
      header: 'Confirme',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.servico.deletarEvento(id).subscribe(() => { 
          this.messageService.add({severity:'success', summary: 'Successo', detail: 'Evento Deletado', life: 3000});
          this.buscarEventos();
        }, err => alert(err));
      }
    });
  }
}
