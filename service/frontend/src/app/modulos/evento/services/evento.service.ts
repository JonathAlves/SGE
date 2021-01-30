import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Evento } from 'src/app/dominios/evento';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class EventoService {

  url = `${environment.apiUrl}/eventos`;

  constructor(private http: HttpClient) { }

  buscarEventoPorId(id: number): Observable<Evento> {
    return this.http.get<Evento>(`${this.url}/${id}`);
  }

  getEventos(): Observable<Evento[]>{
    return this.http.get<Evento[]>(`${this.url}`)
  }

  salvarEvento(evento:Evento): Observable<Evento> {
    return this.http.post<Evento>(this.url, evento);
  }
  
  editarEvento(evento:Evento): Observable<Evento> {
    return this.http.put<Evento>(this.url, evento);
  }

  deletarEvento(id:number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }
}
