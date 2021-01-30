import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from 'src/app/dominios/usuario';
import {environment} from 'src/environments/environment';


@Injectable()
export class MinhaContaService {

  url = `${environment.apiUrl}/minha-conta`;

  constructor( private  http: HttpClient) { }

  getUsuarios(): Observable<Usuario[]>{
    return this.http.get<Usuario[]> (`${this.url}`);

  }
}
