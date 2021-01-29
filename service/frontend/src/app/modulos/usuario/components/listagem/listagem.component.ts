import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/usuario.service';
import { Usuario } from 'src/app/dominios/usuario';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {

  usuarios: Usuario[] = [];

  constructor(
    public servico: UsuarioService
  ) { }

  ngOnInit(): void {
    this.buscarUsuarios();
  }

  private buscarUsuarios() {
    this.servico.getUsuarios()
      .subscribe((usuarios: Usuario[]) => {
        this.usuarios = usuarios;
      });
  }

}
