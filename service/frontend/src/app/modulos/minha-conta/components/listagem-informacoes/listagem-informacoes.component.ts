import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Usuario } from 'src/app/dominios/usuario';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { UsuarioService } from 'src/app/shared/components/services/usuario.service';


@Component({
  selector: 'app-listagem-informacoes',
  templateUrl: './listagem-informacoes.component.html',
  styleUrls: ['./listagem-informacoes.component.css']
})
export class ListagemInformacoesComponent implements OnInit {

  @Input() usuario = new Usuario();
  @Input() edicao = false;
  @Output() usuarioSalvo = new EventEmitter<Usuario>();
  
  usuarios: Usuario[] = [];
  exibirDialog = false;
  formularioEdicao: boolean;
  formEditarUsuario: FormGroup;

  constructor(
    private usuarioService: UsuarioService,
   
  ) { }
  ngOnInit(): void {
    this.buscarUsuarios();
  }

  private buscarUsuarios() {
    this.usuarioService.getUsuarios()
      .subscribe((usuarios: Usuario[]) => {
        this.usuarios = usuarios;
      });
  }

  mostrarDialogEditar(id: number) {
    this.usuarioService.buscarUsuarioPorId(id)
      .subscribe(usuario => {
        this.usuario = usuario
        this.mostrarDialog(true);
      }); 
  }

  mostrarDialog(edicao = false) {
    this.exibirDialog = true;
    this.formularioEdicao = edicao;
  }

 
  salvar() {
    if (this.formEditarUsuario.invalid) {
      alert('Formulário inválido');
      return;
    }

    if (this.edicao) {
      this.usuarioService.editarUsuario(this.usuario)
        .subscribe(usuario => {   
          alert('Usuário Editado');
          this.fecharDialog(usuario);
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    } else {
      this.usuarioService.salvarUsuario(this.usuario)
        .subscribe(usuario => {
          alert('Usuário Salvo');
          this.fecharDialog(usuario);
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    }
  }

  fecharDialog(usuarioSalvo: Usuario) {
    this.usuarioSalvo.emit(usuarioSalvo);
  }

}
