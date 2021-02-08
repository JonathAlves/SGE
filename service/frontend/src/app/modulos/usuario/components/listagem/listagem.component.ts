import { Component, OnInit, Output, EventEmitter} from '@angular/core';
import { ConfirmationService } from 'primeng';
import { Evento } from 'src/app/dominios/evento';
import { Inscricao } from 'src/app/dominios/inscricao';
import { Usuario } from 'src/app/dominios/usuario';
import { UsuarioService } from 'src/app/shared/components/services/usuario.service';


@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {
  @Output() usuarioSalvo = new EventEmitter<Usuario>();
  usuarios: Usuario[] = [];
  usuario = new Usuario();
  exibirDialog = false;
  formularioEdicao: boolean;


  eventoLogado: Evento[] = [];
  usuarioLogado: Usuario;
  inscricoes: Inscricao[] = [];
  eventos: Evento[] = [];
  evento: Evento;

  constructor(
    private servico: UsuarioService,
    private confirmationService: ConfirmationService
  ) { }

  ngOnInit(): void {
    this.buscarUsuarioLogado();
    this.buscarUsuarios();    
    this.buscarInscricoes();  
  }


  buscarUsuarioLogado(){
    this.usuarioLogado = JSON.parse(localStorage.getItem('usuario')) as Usuario;
  }
  

  pegarUsuarioLocal() {
    const usuarioLocal = JSON.parse(window.localStorage.getItem("usuario"));
    this.usuarioSalvo.emit(usuarioLocal);
    return [usuarioLocal];
    
  }

  private buscarUsuarios() {
    this.servico.getUsuarios()
      .subscribe((usuarios: Usuario[]) => {
        this.usuarios = usuarios;
      });
  }

  buscarEvento(){
    this.inscricoes.forEach(inscricao => {
      this.servico.buscarEventoPorId(inscricao.idEvento).
      subscribe(evento => {
        this.evento = evento
      })
    });
  }

  buscarInscricoes(){
    this.servico.getInscricoes()
    .subscribe((inscricoes: Inscricao[]) => {
      this.inscricoes = inscricoes
    })
    
  }

  mostrarDialogEditar(id: number) {
    this.servico.buscarUsuarioPorId(id)
      .subscribe(usuario => {
        this.usuario = usuario;
        this.mostrarDialog(true);
      }); 
  }

  mostrarDialog(edicao = false) {
    this.exibirDialog = true;
    this.formularioEdicao = edicao;
  }

  fecharDialog(usuarioSalvo: Usuario) {
    console.log(usuarioSalvo);
    this.exibirDialog = false;
    this.buscarUsuarios();
  }

  confirmarDeletarUsuario(id: number) {
    this.confirmationService.confirm({
        message: 'Tem certeza que deseja excluir o usuário?',
        accept: () => {
          this.deletarUsuario(id);
        }
    });
  }

  deletarUsuario(id?: number) {
    this.servico.deletarUsuario(id)
      .subscribe(() => {
        alert('Usuário deletado');
        this.buscarUsuarios();
      },
      err => alert(err));
  }

}