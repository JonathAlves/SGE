import { HttpClient } from '@angular/common/http';
import { Injectable, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from 'src/app/dominios/usuario';
import { Chave } from 'src/app/dominios/chave';
import { Inscricao } from 'src/app/dominios/inscricao';
import { Evento } from 'src/app/dominios/evento';

@Injectable()
export class UsuarioService {
  url = `${environment.apiUrl}/usuarios`;
  urlInscricao = `${environment.apiUrl}/inscricoes`;
  urlEvento = `${environment.apiUrl}/eventos`;

  constructor( private  http: HttpClient) { }

  buscarUsuarioPorId(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.url}/${id}`);
  }

  buscarEventoPorId(id: number): Observable<Evento> {
    return this.http.get<Evento>(`${this.urlEvento}/${id}`);
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

  getInscricoes(): Observable<Inscricao[]>{
    return this.http.get<Inscricao[]>(`${this.urlInscricao}`)
  }

  getEventos(): Observable<Evento[]>{
    return this.http.get<Evento[]>(`${this.urlEvento}`)
  }
  }

