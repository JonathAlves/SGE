import { environment } from './../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Inscricao } from 'src/app/dominios/inscricao';
import { Evento } from 'src/app/dominios/evento';



@Injectable()

export class MinhaContaService {


  urlInscricao = `${environment.apiUrl}/inscricoes`
  urlEvento = `${environment.apiUrl}/eventos`

  constructor(private http: HttpClient) { }

  getInscricoes(): Observable<Inscricao[]>{
    return this.http.get<Inscricao[]>(`${this.urlInscricao}`);
  }

  buscarEventoPorId(id: number): Observable<Evento> {
    return this.http.get<Evento>(`${this.urlEvento}/${id}`);
  }

  getEventos(): Observable<Evento[]>{
    return this.http.get<Evento[]>(`${this.urlEvento}`);
  }

  deletarInscricao(id: number): Observable<Inscricao>{
    return this.http.delete<Inscricao>(`${this.urlInscricao}/${id}`)
  }
}
