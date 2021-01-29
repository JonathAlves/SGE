import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from 'src/app/dominios/usuario';

@Injectable()
export class UsuarioService {
  url = `${environment.apiUrl}/usuarios`;

  constructor( private  http: HttpClient) { }

  buscarUsuarioPorId(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.url}/${id}`);
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
//sad

  }

