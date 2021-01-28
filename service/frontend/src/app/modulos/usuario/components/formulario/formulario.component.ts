import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Usuario } from 'src/app/dominios/usuario';
import { UsuarioService } from '../../servicos/usuario.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  formUsuario: FormGroup;
  usuario = new Usuario();

  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuarioService
  ) { }

  ngOnInit(): void {
    this.criarUsuario();
   
  }

  criarUsuario(){
    this.formUsuario = this.fb.group({
      nome: ['', Validators.minLength(3)],
      cpf: ['', Validators.maxLength(11)],
      email: ['', Validators.email], 
      telefone: '',
      dataNascimento: '',
    });
  }

  salvar() {
    if (this.formUsuario.invalid) {
      alert('Formulário inválido');
      return;
    }

    this.usuarioService.salvarUsuario(this.usuario)
      .subscribe(usuario => {
        console.log('usuario salvo', usuario);
        alert('Usuário Salvo')
      }, (erro: HttpErrorResponse) => {
        alert(erro.error.message);
      });
    }

}
