import { Component, OnInit} from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng';
import { Evento } from 'src/app/dominios/evento';
import { Usuario } from 'src/app/dominios/usuario';
import { EventoService } from '../../services/evento.service';
import { Inscricao } from 'src/app/dominios/inscricao';


@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})

export class ListagemComponent implements OnInit {

  eventos: Evento[] = [];
  evento = new Evento();
  usuario = new Usuario();
  inscricao = new Inscricao();
  selectedEvento: Evento[] = [];
  formularioEdicao: boolean;
  exibirDialog = false;

  statuses: any[];

  constructor(
    private servico: EventoService,
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
   
  ) { }

  ngOnInit(): void {
    this.buscarEventos();
    
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

  deletarTodosEvento() {
    this.confirmationService.confirm({
      message: 'Você tem certeza que quer deletar todos os eventos? ',
      header: 'Confirma',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.eventos.forEach(evento => {
          this.servico.deletarEvento(evento.id).subscribe(() => { 
            this.messageService.add({severity:'success', summary: 'Successo', detail: 'Eventos Deletados', life: 3000});
            this.buscarEventos();
          }, err => alert(err));
        });
      }
  });
  }

  deletarEvento(id?: number) {
    this.confirmationService.confirm({
      message: 'Você tem certeza que quer deletar o evento ' + this.evento.titulo + '?',
      header: 'Confirma',
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
