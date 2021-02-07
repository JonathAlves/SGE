
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit, Output, EventEmitter, Input} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Usuario } from 'src/app/dominios/usuario';
import { HttpErrorResponse } from '@angular/common/http';
import { UsuarioService } from '../services/usuario.service';
import { MessageService } from 'primeng';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-formulario-usuario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  @Input() usuario = new Usuario();
  @Input() edicao = false;
  @Output() usuarioSalvo = new EventEmitter<Usuario>();

  formUsuario: FormGroup;
  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuarioService,
    private route: ActivatedRoute,
    private messageService: MessageService,
  ) { }

  ngOnInit(): void {
    this.criarUsuario();
  }


  criarUsuario(){
    this.route.params.subscribe(params => {
        if (params.id) {
          this.edicao = true;
          this.buscarUsuario(params.id);
        }
      });

      this.usuario.admin = false;
      this.formUsuario = this.fb.group({
        nome: ['', [Validators.required, Validators.minLength(3)]],
        cpf:  ['', [Validators.required]],
        email: ['', [Validators.required, Validators.email]],
        telefone: ['', [Validators.required, Validators.minLength(13), Validators.maxLength(20)]],
        dataNascimento: ['', Validators.required],



      });

  }

  buscarUsuario(id: number) {
    this.usuarioService.buscarUsuarioPorId(id)
      .subscribe(usuario => this.usuario = usuario);
  }

  salvar() {

    if (this.formUsuario.invalid) {
      this.messageService.add({severity:'error', summary: 'Error', detail: 'Formulario Invalido!', life: 3000});
      return;

    }

    if (this.edicao) {
      this.usuarioService.editarUsuario(this.usuario)
        .subscribe(usuario => {
          this.messageService.add({severity:'success', summary: 'Successo', detail: 'Usuario editado com sucesso!', life: 3000});
          this.fecharDialog(usuario);
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    } else {
      this.usuarioService.salvarUsuario(this.usuario)
        .subscribe(usuario => {
            this.removerMask();
          this.messageService.add({severity:'success', summary: 'Successo', detail: 'Usuario Cadastrado com sucesso!', life: 3000});
          this.fecharDialog(usuario);
        }, (erro: HttpErrorResponse) => {
          this.messageService.add({severity:'error', summary: 'Error', detail: erro.error.message, life: 3000});

        });
    }
  }

  fecharDialog(usuarioSalvo: Usuario) {
    this.usuarioSalvo.emit(usuarioSalvo);
  }

  removerMask(){
      var removerMaskCPF = this.formUsuario.get('cpf').value.replace('.','').replace('.', '').replace('-', '');
      var removerMaskTelefone = this.formUsuario.get('telefone').value.replace('+','').replace('()', '').replace('', '').replace('', '').replace('-', '');

      this.formUsuario.setValue({
          nome: this.formUsuario.get('nome').value,
          cpf: removerMaskCPF,
          email: this.formUsuario.get('email').value,
          telefone: removerMaskTelefone,
          dataNascimento: this.formUsuario.get('dataNascimento').value,

      })
  }


}
