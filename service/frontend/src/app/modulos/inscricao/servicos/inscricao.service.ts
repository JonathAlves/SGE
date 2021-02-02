import { Evento } from 'src/app/dominios/evento';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Inscricao } from 'src/app/dominios/inscricao';

@Injectable({
  providedIn: 'root'
})
export class InscricaoService {

  url = `${environment.apiUrl}/inscricoes`;

  constructor(private http: HttpClient) { }

  buscarInscricaoPorId(id: number): Observable<Inscricao> {
    return this.http.get<Inscricao>(`${this.url}/${id}`);
  }

  salvarInscricao(inscricao: Inscricao): Observable<Inscricao>{
    return this.http.post<Inscricao>(this.url, inscricao)
  }
}
