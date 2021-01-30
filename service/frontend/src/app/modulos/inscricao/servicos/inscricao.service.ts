import { Evento } from 'src/app/dominios/evento';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class InscricaoService {

  url = `${environment.apiUrl}/eventos`;

  constructor(private http: HttpClient) { }

  buscarEventoPorId(id: number): Observable<Evento> {
    return this.http.get<Evento>(`${this.url}/${id}`);
  }
}
