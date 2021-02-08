import { InscricaoService } from './../../../inscricao/servicos/inscricao.service';
import { MinhaContaService } from './../../service/minha-conta.service';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Usuario } from 'src/app/dominios/usuario';
import { FormGroup } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { UsuarioService } from 'src/app/shared/components/services/usuario.service';
import { Inscricao } from 'src/app/dominios/inscricao';
import { Evento } from 'src/app/dominios/evento';
import { ConfirmationService, MessageService } from 'primeng';


@Component({
  selector: 'app-listagem-informacoes',
  templateUrl: './listagem-informacoes.component.html',
  styleUrls: ['./listagem-informacoes.component.css']
})
export class ListagemInformacoesComponent implements OnInit {

  @Input() usuario = new Usuario();
  @Input() edicao = false;
  @Output() usuarioSalvo = new EventEmitter<Usuario>();

  usuarios: Usuario;
  usrEvento: Usuario;
  eventos: Evento[] = [];
  evento: Evento;
  inscricoes: Inscricao[] = [];
  exibirDialog = false;
  formularioEdicao: boolean;
  formEditarUsuario: FormGroup;
  


  constructor(
    private usuarioService: UsuarioService,
    private servico: MinhaContaService,
    private confirmationService: ConfirmationService,
    private messageService: MessageService,
  ) { }
  ngOnInit(): void {
    this.pegarUsuarioLocal()
    this.buscarInscricoes();

    

  }
  pegarUsuarioLocal() {
    const usuarioLocal = JSON.parse(window.localStorage.getItem("usuario"));
    this.usuarioSalvo.emit(usuarioLocal);
    return [usuarioLocal];
  }

  buscarInscricoes() {
    const usrLocal: Usuario = JSON.parse(window.localStorage.getItem("usuario"));
    this.servico.getInscricoes()
    .subscribe((inscricoes: Inscricao[]) => {
      this.inscricoes = inscricoes
    });
    this.usrEvento = usrLocal
    this.buscarEvento();
  }
  
  buscarEvento(){
      this.servico.getEventos()
      .subscribe((eventos: Evento[]) => {
        for (let i = 0; i < this.inscricoes.length; i++) {
            if(this.inscricoes[i].idEvento == eventos[i].id){
              this.eventos = eventos
              
            }
            console.log(this.inscricoes.length)
        }
        
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


  confirmarDeletarInscricao(id: number) {
    this.confirmationService.confirm({
      message: 'Você tem certeza que quer cancelar a inscrição ?',
      accept: () => {
        this.servico.deletarInscricao(id)
        
      }
    });
  }

  deletarInscricao(id?: number) {
    this.servico.deletarInscricao(id)
      .subscribe(() => {
        alert('Inscrição deletada');
        this.buscarInscricoes();
      },
      err => alert(err));
  }

  fecharDialog(usuarioSalvo: Usuario) {
    this.usuarioSalvo.emit(usuarioSalvo);
  }
    logout(){
    localStorage.clear()
    location.reload()
  }

}
