import { Evento } from 'src/app/dominios/evento';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Inscricao } from 'src/app/dominios/inscricao';
import { Pergunta } from 'src/app/dominios/pergunta';


@Injectable()
export class InscricaoService {

  url = `${environment.apiUrl}/inscricoes`;
  urlEvento =`${environment.apiUrl}/eventos`
  urlPergunta = `${environment.apiUrl}/perguntas`

  constructor(private http: HttpClient) { }

  buscarEventoPorId(id: number): Observable<Evento> {
    return this.http.get<Evento>(`${this.urlEvento}/${id}`);
  }

  buscarPerguntaPorId(id: number): Observable<Pergunta> {
    return this.http.get<Pergunta>(`${this.url}/${id}`);
  }

  buscarInscricaoPorId(id: number): Observable<Inscricao> {
    return this.http.get<Inscricao>(`${this.url}/${id}`);
  }

  salvarInscricao(inscricao: Inscricao): Observable<Inscricao>{
    return this.http.post<Inscricao>(this.url, inscricao);
  }

  getInscricoes(): Observable<Inscricao[]>{
    return this.http.get<Inscricao[]>(`${this.url}`);
  }

  getPerguntas(): Observable<Pergunta[]>{
    return this.http.get<Pergunta[]>(`${this.urlPergunta}`);
  }

  deletarInscricao(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }
}
