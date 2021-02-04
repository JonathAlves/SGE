import { Component, OnInit, Output, EventEmitter, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Usuario } from 'src/app/dominios/usuario';
import { Chave } from 'src/app/dominios/chave';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {

    @Output() emitUsuario: EventEmitter<Usuario> = new EventEmitter
    exibirDialog = false;
    formularioLogin: boolean;
    chaveInput: string;
    formChave: FormGroup;
    chave = new Chave();



    constructor(public usuarioService: UsuarioService, private fbuilder: FormBuilder) { }

    ngOnInit(): void {
      this.pegarUsuarioLocal();

      this.formChave = this.fbuilder.group({ chave: '' })

    }

    mostrarDialog(edicao = false) {
      this.exibirDialog = true;
      this.formularioLogin = edicao;
    }
  
    fecharDialog(usuarioSalvo: Usuario) {
      console.log(usuarioSalvo);
      this.exibirDialog = false;
    }

    pegarUsuarioLocal() {
        const usuario = JSON.parse(window.localStorage.getItem("usuario"));
        this.emitUsuario.emit(usuario);
    }
      logarUsuario(chaveInput: string){
        this.chave.chave = chaveInput
        this.usuarioService.buscarUsuarioPorChave(this.chave).subscribe((usuario :Usuario)=>{
          this.emitUsuario.emit(usuario);
          localStorage.setItem("usuario", JSON.stringify(usuario));
        })

      }

      logout(){
        localStorage.clear()
        location.reload()
      }

}
