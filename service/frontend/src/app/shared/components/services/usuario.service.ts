import { HttpClient } from '@angular/common/http';
import { Injectable, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from 'src/app/dominios/usuario';
import { Chave } from 'src/app/dominios/chave';

@Injectable()
export class UsuarioService {
  url = `${environment.apiUrl}/usuarios`;



  constructor( private  http: HttpClient) { }

  buscarUsuarioPorId(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.url}/${id}`);
  }
  buscarUsuarioPorChave(chave: Chave){
    return this.http.post<Usuario>(`${this.url}/login`, chave);

  }

  getUsuarios(): Observable<Usuario[]>{
    return this.http.get<Usuario[]> (`${this.url}`);

  }
  salvarUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(this.url, usuario);
  }

  editarUsuario(usario: Usuario): Observable<Usuario>{
    return this.http.put<Usuario>(this.url, usario);
  }

  deletarUsuario(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  }

