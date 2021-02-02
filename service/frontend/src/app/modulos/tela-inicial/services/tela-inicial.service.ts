import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Evento } from 'src/app/dominios/evento';
import { environment } from 'src/environments/environment';

@Injectable()
export class TelaInicialService {


  url = `${environment.apiUrl}/tela-inicial`;
  constructor(http: HttpClient) { }

  buscarEventoPorId(id: number): Observable<Evento> {
    return this.http.get<Evento>(`${this.url}/${id}`);
  }
}
