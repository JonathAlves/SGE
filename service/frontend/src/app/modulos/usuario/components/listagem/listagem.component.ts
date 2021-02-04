import { Component, OnInit, Output, EventEmitter} from '@angular/core';
import { ConfirmationService } from 'primeng';
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

  usuarioLogado: Usuario;

  constructor(
    private servico: UsuarioService,
    private confirmationService: ConfirmationService
  ) { }

  ngOnInit(): void {
    this.buscarUsuarios();
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